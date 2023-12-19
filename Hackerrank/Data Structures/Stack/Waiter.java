import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {
    public static List<Integer> waiter(List<Integer> number, int q) {
        BigInteger bigInteger = new BigInteger("1");

        Stack<Integer> A = new Stack<>();

        for (int i = 0; i < number.size(); i++) {
            A.add(number.get(i));
        }

        Stack<Integer> B = new Stack<>();

        List<Integer> ans = new ArrayList<>();

        while (q > 0 && !A.isEmpty()) {
            bigInteger = bigInteger.nextProbablePrime();
            Integer prime = Integer.valueOf(bigInteger.toString());

            Stack<Integer> temp = new Stack<>();

            while (!A.isEmpty()) {
                Integer num = A.pop();

                if (num % prime == 0) {
                    B.add(num);
                } else {
                    temp.add(num);
                }
            }

            A = temp;

            while (!B.isEmpty()) {
                ans.add(B.pop());
            }
            q--;
        }

        while (!A.isEmpty()) {
            ans.add(A.pop());
        }

        return ans;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> number = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.waiter(number, q);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n");

        bufferedReader.close();
        bufferedWriter.close();
    }
}

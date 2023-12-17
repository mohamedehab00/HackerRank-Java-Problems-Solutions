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

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        Stack<Integer> stack1 = new Stack<>();
        int tot1 = 0;
        Stack<Integer> stack2 = new Stack<>();
        int tot2 = 0;
        Stack<Integer> stack3 = new Stack<>();
        int tot3 = 0;

        for (int i = h1.size()-1; i >= 0; i--) {
            tot1+=h1.get(i);
            stack1.add(h1.get(i));
        }
        for (int i = h2.size()-1; i >= 0; i--) {
            tot2+=h2.get(i);
            stack2.add(h2.get(i));
        }
        for (int i = h3.size()-1; i >= 0; i--) {
            tot3+=h3.get(i);
            stack3.add(h3.get(i));
        }

        while (tot1 != tot2 || tot1 != tot3 || tot2 != tot3){
            if (tot1 > tot2 || tot1 > tot3){
                tot1 -= stack1.peek();
                stack1.pop();
            }
            if (tot2 > tot1 || tot2 > tot3){
                tot2 -= stack2.peek();
                stack2.pop();
            }
            if (tot3 > tot1 || tot3 > tot1){
                tot3 -= stack3.peek();
                stack3.pop();
            }
        }

        return tot1;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n1 = Integer.parseInt(firstMultipleInput[0]);

        int n2 = Integer.parseInt(firstMultipleInput[1]);

        int n3 = Integer.parseInt(firstMultipleInput[2]);

        List<Integer> h1 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> h2 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> h3 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.equalStacks(h1, h2, h3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

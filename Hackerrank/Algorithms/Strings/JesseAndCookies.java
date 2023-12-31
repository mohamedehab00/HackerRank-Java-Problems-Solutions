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
    public static int cookies(int k, List<Integer> A) {
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            if (o1 <= o2) {
                return -1;
            } else {
                return 1;
            }
        });

        for (int i = 0; i < A.size(); i++) {
            priorityQueue.add(A.get(i).longValue());
        }
        int count = 0;
        boolean ans = true;

        while (true) {
            if (priorityQueue.isEmpty()) {
                ans = false;
                break;
            }

            Long a1 = priorityQueue.peek();
            priorityQueue.poll();

            if (a1 >= k) {
                break;
            }

            if (priorityQueue.isEmpty()) {
                if (a1 < k) {
                    ans = false;
                }
                break;
            }

            Long a2 = priorityQueue.peek();
            priorityQueue.poll();

            Long res = a1 + a2 * 2;
            count++;
            priorityQueue.add(res);
        }

        if (ans) {
            return count;
        } else {
            return -1;
        }
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.cookies(k, A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

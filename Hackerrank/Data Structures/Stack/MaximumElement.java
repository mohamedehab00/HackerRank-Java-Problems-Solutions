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
    public static List<Integer> getMax(List<String> operations) {
        List<Integer> list = new ArrayList<>();

        Stack<Integer> stack = new Stack<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(
                (o1, o2) -> {
                    if (o1 >= o2) {
                        return -1;
                    } else {
                        return 1;
                    }
                });

        for (String op : operations) {
            String[] tokens = op.split(" ");
            if (tokens[0].equals("1")) {
                stack.add(Integer.valueOf(tokens[1]));
                priorityQueue.add(stack.peek());
            } else if (tokens[0].equals("2")) {
                priorityQueue.remove(stack.pop());
            } else {
                list.add(priorityQueue.peek());
            }
        }

        return list;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> ops = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        List<Integer> res = Result.getMax(ops);

        bufferedWriter.write(
                res.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n");

        bufferedReader.close();
        bufferedWriter.close();
    }
}
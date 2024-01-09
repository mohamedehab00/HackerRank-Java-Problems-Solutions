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

    public static LinkedList<LinkedList<Integer>> mergeToStacks(List<Integer> p) {
        LinkedList<LinkedList<Integer>> stacks = new LinkedList<>();
        LinkedList<Integer> temp = new LinkedList<>();

        for (int i = p.size() - 1; i >= 0; i--) {
            if (temp.isEmpty()) {
                temp.add(p.get(i));
            } else {
                if (temp.getFirst() <= p.get(i)) {
                    temp.add(0, p.get(i));
                } else {
                    stacks.add(0, temp);
                    temp = new LinkedList<>();
                    temp.add(p.get(i));
                }
            }
        }
        if (!temp.isEmpty()) {
            stacks.add(0, temp);
        }

        return stacks;
    }

    public static LinkedList<LinkedList<Integer>> mergeToList(LinkedList<LinkedList<Integer>> stacks) {
        LinkedList<LinkedList<Integer>> list = new LinkedList<>();

        list.add(stacks.get(0));

        for (int i = 1; i < stacks.size(); i++) {
            LinkedList<Integer> curr = stacks.get(i);
            if (curr.isEmpty()) {
                continue;
            }
            if (list.getLast().getLast() >= curr.getFirst()) {
                for (int j = 0; j < curr.size(); j++) {
                    list.getLast().add(curr.get(j));
                }
                LinkedList<Integer> temp = list.getLast();
                list.removeLast();
                list.addLast(temp);
            } else {
                list.addLast(curr);
            }
        }

        return list;
    }

    public static int poisonousPlants(List<Integer> p) {
        LinkedList<LinkedList<Integer>> stacks = mergeToStacks(p);

        int ans = 0;

        while (stacks.size() > 1) {
            for (int i = 1; i < stacks.size(); i++) {
                stacks.get(i).pop();
            }
            ans++;
            stacks = mergeToList(stacks);
        }

        return ans;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> p = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.poisonousPlants(p);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

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
    public static List<Integer> componentsInGraph(List<List<Integer>> gb) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        HashSet<Integer> nodes = new HashSet<>();

        for (int i = 0; i < gb.size(); i++) {
            Integer from = gb.get(i).get(0);
            Integer to = gb.get(i).get(1);

            List<Integer> toNodes = graph.getOrDefault(from, new ArrayList<>());
            List<Integer> fromNodes = graph.getOrDefault(to, new ArrayList<>());

            toNodes.add(to);
            fromNodes.add(from);

            graph.put(from, toNodes);
            graph.put(to, fromNodes);

            nodes.add(from);
            nodes.add(to);
        }
        int maxNodes = Integer.MIN_VALUE;
        int minNodes = Integer.MAX_VALUE;
        int[] visited = new int[2 * gb.size()];
        for (Integer node : nodes) {
            if (visited[node - 1] == 1) {
                continue;
            }
            int comp = traverseGraph(node, graph, visited);
            maxNodes = Math.max(comp, maxNodes);
            minNodes = Math.min(comp, minNodes);
        }

        List<Integer> ans = new ArrayList<>();

        ans.add(minNodes);
        ans.add(maxNodes);

        return ans;
    }

    private static int traverseGraph(Integer node, HashMap<Integer, List<Integer>> gp, int[] visited) {
        if (visited[node - 1] == 1) {
            return 0;
        }
        visited[node - 1] = 1;

        int sumConnectedComps = 0;

        List<Integer> childs = gp.get(node);

        for (int i = 0; i < childs.size(); i++) {
            sumConnectedComps += traverseGraph(childs.get(i), gp, visited);
        }

        return 1 + sumConnectedComps;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> gb = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                gb.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList()));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = Result.componentsInGraph(gb);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n");

        bufferedReader.close();
        bufferedWriter.close();
    }
}

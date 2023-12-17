import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        StringBuilder builder = new StringBuilder("");
        Stack<String> stack = new Stack<>();

        int Q = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < Q; i++) {
            String[] query = scan.nextLine().split(" ");

            if (query[0].equals("1")) {
                stack.add(builder.toString());
                builder.append(query[1]);
            } else if (query[0].equals("2")) {
                stack.add(builder.toString());
                int range = Integer.valueOf(query[1]);
                builder.delete(builder.length() - range, builder.length());
            } else if (query[0].equals("3")) {
                System.out.println(builder.charAt(Integer.valueOf(query[1]) - 1));
            } else if (query[0].equals("4")) {
                builder = new StringBuilder(stack.pop());
            }
        }
    }
}

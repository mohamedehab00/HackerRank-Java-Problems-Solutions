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

    public static String pangrams(String s) {
        int[] arr = new int[26];
        int appear = 26;

        for (int i = 0; i < s.length(); i++) {
            char curr = Character.toLowerCase(s.charAt(i));

            if (!Character.isLetter(curr)) {
                continue;
            }

            int idx = curr - 97;

            if (arr[idx] == 0) {
                arr[idx] = 1;
                appear--;
            }
        }

        if (appear == 0) {
            return "pangram";
        } else {
            return "not pangram";
        }
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.pangrams(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

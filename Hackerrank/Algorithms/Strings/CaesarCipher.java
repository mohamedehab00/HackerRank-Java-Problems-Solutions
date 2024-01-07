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

    public static String caesarCipher(String s, int k) {
        String alphapet = "abcdefghijklmnopqrstuvwxyz";
        String encryption = "";

        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                int curr = Character.toLowerCase(s.charAt(i));
                int next = (curr - 97 + k) % 26;
                char nextChar = alphapet.charAt(next);
                if (Character.isUpperCase(s.charAt(i))) {
                    encryption += Character.toUpperCase(nextChar);
                } else {
                    encryption += nextChar;
                }
            } else {
                encryption += s.charAt(i);
            }
        }

        return encryption;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

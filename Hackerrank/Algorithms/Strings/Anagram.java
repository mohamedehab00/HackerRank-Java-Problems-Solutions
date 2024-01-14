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

    public static int anagram(String s) {
        if (s.length() % 2 != 0) {
            return -1;
        }

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        int ans = 0;

        for (int i = 0; i < s.length() / 2; i++) {
            freq1[s.charAt(i) - 97]++;
        }

        for (int i = s.length() / 2; i < s.length(); i++) {
            freq2[s.charAt(i) - 97]++;
        }

        for (int i = 0; i < 26; i++) {
            if (freq2[i] == 0) {
                continue;
            } else {
                if (freq2[i] > freq1[i]) {
                    ans += (freq2[i] - freq1[i]);
                }
            }
        }

        return ans;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = Result.anagram(s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

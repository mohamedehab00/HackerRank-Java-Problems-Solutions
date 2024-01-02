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

    public static int minimumNumber(int n, String password) {

        String special_characters = "!@#$%^&*()-+";

        boolean isLenOk = false;
        boolean isDigitOk = false;
        boolean isLowCharOk = false;
        boolean isUpperCharOk = false;
        boolean isSpecialCharOk = false;

        if (password.length() >= 6) {
            isLenOk = true;
        }

        for (int i = 0; i < password.length(); i++) {
            char curr = password.charAt(i);
            if (Character.isDigit(curr)) {
                isDigitOk = true;
                continue;
            }

            if (Character.isUpperCase(curr)) {
                isUpperCharOk = true;
                continue;
            }

            if (Character.isLowerCase(curr)) {
                isLowCharOk = true;
                continue;
            }

            if (special_characters.contains(String.valueOf(curr))) {
                isSpecialCharOk = true;
                continue;
            }
        }
        int ans = 0;

        if (isLenOk && isDigitOk && isLowCharOk && isUpperCharOk && isSpecialCharOk) {
            return ans;
        }

        if (!isDigitOk) {
            ans += 1;
        }
        if (!isLowCharOk) {
            ans += 1;
        }
        if (!isUpperCharOk) {
            ans += 1;
        }
        if (!isSpecialCharOk) {
            ans += 1;
        }

        if (ans + password.length() < 6) {
            ans += (6 - (ans + password.length()));
        }

        return ans;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String password = bufferedReader.readLine();

        int answer = Result.minimumNumber(n, password);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

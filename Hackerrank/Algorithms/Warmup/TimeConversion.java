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

    public static String timeConversion(String s) {
        int h = Integer.parseInt(s.substring(0, 2));

        String time = s.substring(s.length() - 2);

        if (time.equals("AM")) {
            if (h == 12) {
                h = 0;
            }
        } else {
            if (h != 12) {
                h = 12 - h;
                h = 24 - h;
            }
        }

        String newHour = String.format("%02d", h);

        return newHour + s.substring(2, s.length() - 2);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.security.*;

public class Solution {
    public static void main(String[] args) {
        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
         * class should be named Solution.
         */
        Scanner scanner = new Scanner(System.in);
        try {
            String ans = scanner.nextLine();
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] theMD5digest = md.digest(ans.getBytes(StandardCharsets.UTF_8));
            BigInteger no = new BigInteger(1, theMD5digest);
            String hashtext = no.toString(16);
            while (hashtext.length() < 64) {
                hashtext = "0" + hashtext;
            }
            System.out.println(hashtext);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
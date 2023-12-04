import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);

        BigInteger bigInteger = new BigInteger(scanner.nextLine());
        BigInteger bigInteger1 = new BigInteger(scanner.nextLine());

        System.out.println(bigInteger.add(bigInteger1));
        System.out.println(bigInteger.multiply(bigInteger1));
    }
}
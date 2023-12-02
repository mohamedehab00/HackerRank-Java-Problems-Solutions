import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        System.out.println(A.length()+B.length());

        if (A.compareTo(B) >= 1){
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }

        char firstCharA = A.charAt(0);
        firstCharA = Character.toUpperCase(firstCharA);
        char firstCharB = B.charAt(0);
        firstCharB = Character.toUpperCase(firstCharB);

        A = firstCharA + A.substring(1);
        B = firstCharB + B.substring(1);

        System.out.println(A+" "+B);
    }
}




import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        // Write your code here.
        s = s.trim();
        
        String[] arr = s.split("[^A-Za-z]+");

        if(s.length() == 0){
            System.out.println(0);
        }
        else {
            System.out.println(arr.length);
            for (int i = 0; i < arr.length; i++) {
                System.out.println(arr[i]);
            }
        }

        scan.close();
    }
}


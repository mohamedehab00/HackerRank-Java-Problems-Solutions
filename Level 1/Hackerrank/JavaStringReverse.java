import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String []argh){
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        // Write your code here.
        String ans = "Yes";
        int l = 0, r = s.length()-1;
        while (l < r){
            if (s.charAt(l)!=s.charAt(r)){
                ans = "No";
                break;
            }
            l++;
            r--;
        }
        System.out.println(ans);
    }
}

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        List<Integer> list = new ArrayList<>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            list.add(scan.nextInt());
        }

        int q = scan.nextInt();

        for (int i = 0; i < q; i++) {
            scan.nextLine();
            String operation = scan.nextLine();

            if (operation.equals("Insert")){
                int x = scan.nextInt();
                int y = scan.nextInt();

                list.add(x,y);
            }
            else {
                int x = scan.nextInt();
                list.remove(x);
            }
        }

        for (Integer num:
             list) {
            System.out.print(num+" ");
        }
    }
}
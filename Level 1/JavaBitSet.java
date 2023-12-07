import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        BitSet set1 = new BitSet();
        BitSet set2 = new BitSet();

        for (int i = 0; i < n; i++) {
            set1.set(0,0);
            set2.set(0,0);
        }

        for (int i = 0; i < m; i++) {
            scanner.nextLine();
            String opr = scanner.next();
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            if(opr.equals("AND")){
                if(x == 1){
                    set1.and(set2);
                }else {
                    set2.and(set1);
                }
            } else if (opr.equals("OR")) {
                if(x == 1){
                    set1.or(set2);
                }else {
                    set2.or(set1);
                }
            } else if (opr.equals("XOR")) {
                if(x == 1){
                    set1.xor(set2);
                }else {
                    set2.xor(set1);
                }
            } else if (opr.equals("FLIP")) {
                if(x == 1){
                    set1.flip(y);
                }else {
                    set2.flip(y);
                }
            } else if (opr.equals("SET")) {
                if(x == 1){
                    set1.set(y);
                }else {
                    set2.set(y);
                }
            }
            System.out.println(set1.cardinality()+" "+set2.cardinality());
        }
    }
}
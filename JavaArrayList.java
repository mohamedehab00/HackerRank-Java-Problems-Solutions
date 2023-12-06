import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int size = scanner.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                arr.add(scanner.nextInt());
            }
            list.add(arr);
        }
        int queries = scanner.nextInt();
        for (int i = 0; i < queries; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            try {
                int ans = list.get(x-1).get(y-1);
                System.out.println(ans);
            }
            catch (Exception e){
                System.out.println("ERROR!");
            }
        }
    }
}
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        while(scanner.hasNext()){
          String x = scanner.nextLine();
          System.out.println(++n+" "+x);
        };
    }
}
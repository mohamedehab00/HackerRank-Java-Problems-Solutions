import java.io.*;
import java.util.*;

public class Solution {

        static int B;
    static int H;

    static {
        Scanner scanner = new Scanner(System.in);
        B = scanner.nextInt();
        H = scanner.nextInt();
    }
    public static void main(String []argh){
        if (B > 0 && H > 0){
            System.out.println(B*H);
        }
        else {
            System.out.println("java.lang.Exception: Breadth and height must be positive");
        }}
}
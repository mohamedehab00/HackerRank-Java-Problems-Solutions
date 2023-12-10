import java.util.*;
import java.text.*;

public class Solution {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();
        
        // Write your code here.
        NumberFormat f = NumberFormat.getCurrencyInstance(Locale.US);
        String us = f.format(payment);
        f = NumberFormat.getCurrencyInstance(new Locale("en","IN"));
        String india = f.format(payment);
        f = NumberFormat.getCurrencyInstance(Locale.CHINA);
        String china = f.format(payment);
        f = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        String france = f.format(payment);
        
        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
    }
}
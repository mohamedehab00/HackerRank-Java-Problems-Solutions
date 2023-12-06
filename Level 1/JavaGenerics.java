import java.io.*;
import java.util.*;

public class Solution {
    public static <T> void printArray(T[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Integer[] intArr = {1,2,3}; 
        String[] strArr = {"Hello","World"};
        
        printArray(intArr);
        printArray(strArr);
    }
}
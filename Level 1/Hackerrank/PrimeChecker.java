import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.lang.reflect.*;

class Prime{
    public ArrayList<Integer> primes = new ArrayList<>();
    
        boolean isPrime(int x){
        if (x == 1){
            return false;
        }
        if(primes.contains(x)){
            return true;
        }
        for (int i = 2; i < x; i++) {
            if(x % i == 0){
                return false;
            }
        }
        primes.add(x);
        return true;
    }
    void checkPrime(int ...arr){
        for (int i = 0; i < arr.length; i++) {
            if(isPrime(arr[i])){
                System.out.print(arr[i]+" ");
            }
        }
        System.out.println();
    }
}

public class Solution {

    public static void main(String[] args) {
        try{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n1=Integer.parseInt(br.readLine());
        int n2=Integer.parseInt(br.readLine());
        int n3=Integer.parseInt(br.readLine());
        int n4=Integer.parseInt(br.readLine());
        int n5=Integer.parseInt(br.readLine());
        Prime ob=new Prime();
        ob.checkPrime(n1);
        ob.checkPrime(n1,n2);
        ob.checkPrime(n1,n2,n3);
        ob.checkPrime(n1,n2,n3,n4,n5);    
        Method[] methods=Prime.class.getDeclaredMethods();
        Set<String> set=new HashSet<>();
        boolean overload=false;
        for(int i=0;i<methods.length;i++)
        {
            if(set.contains(methods[i].getName()))
            {
                overload=true;
                break;
            }
            set.add(methods[i].getName());
            
        }
        if(overload)
        {
            throw new Exception("Overloading not allowed");
        }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
}




import java.util.*;
import java.io.*;

class Solution{
    public static void main(String []argh)
    {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        in.nextLine();
        HashMap<String, Integer> table = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            String name=in.nextLine();
            int phone=in.nextInt();
            in.nextLine();
            table.put(name, phone);
        }
        while(in.hasNext())
        {
            String s=in.nextLine();
            if(table.containsKey(s)) {
                Integer phone = table.get(s);
                System.out.println(String.format("%s=%d", s,phone));
            }
            else {
                System.out.println("Not found");
            }
        }
    }
}



import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution{
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
        Pattern pattern = Pattern.compile("<(.+)>(([^<>]+))<\\/\\1>");
                
		while(testCases>0){
			String line = in.nextLine();
			
          	//Write your code here
			Matcher matcher = pattern.matcher(line);

            if (matcher.find() == false){
                System.out.println("None");
                testCases--;
                continue;
            }
            else{
                String result = matcher.group(3);
                System.out.println(result);
            }
            while (matcher.find()) {
                String result = matcher.group(3);
                System.out.println(result);
            }
			testCases--;
		}
	}
}




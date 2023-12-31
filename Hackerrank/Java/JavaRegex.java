import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

class Solution{

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }

    }
}

//Write your code here
/**
 * InnerSolution
 */
class MyRegex{
    public String pattern = "(([0-2]{0,1}[0-4]{0,1}[0-9]{0,1})|([0-2]{0,1}[0-5]{0,1}[0-5]{0,1})|([0-9]{0,1}[0-9]{0,1})|"+
            "([1][0-9]{0,1}[0-9]{0,1}))\\.(([0-2]{0,1}[0-4]{0,1}[0-9]{0,1})|([0-2]{0,1}[0-5]{0,1}[0-5]{0,1})|([0-9]{0,1}[0-9]{0,1}"
            +")|([1][0-9]{0,1}[0-9]{0,1}))\\.(([0-2]{0,1}[0-4]{0,1}[0-9]{0,1})|([0-2]{0,1}[0-5]{0,1}[0-5]{0,1})|([0-9]{0,1}[0-9]{0,1}"+")|([1][0-9]{0,1}[0-9]{0,1}))\\.(([0-2]{0,1}[0-4]{0,1}[0-9]{0,1})|([0-2]{0,1}[0-5]{0,1}[0-5]{0,1})|([0-9]{0,1}[0-9]{0,1"+
            "})|([1][0-9]{0,1}[0-9]{0,1}))";
}
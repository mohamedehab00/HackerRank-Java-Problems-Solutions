import java.util.*;
class Solution{
	
    public static void main(String []argh)
    {
        Scanner sc = new Scanner(System.in);
        
        while (sc.hasNext()) {
            String input=sc.next();
            //Complete the code
            Stack<Character> st = new Stack<>();
            
            for (int i = 0; i < input.length(); i++) {
                if(st.empty()) {
                    st.push(input.charAt(i));
                }
                else {
                    if ((input.charAt(i) == ')' && st.peek()  == '(') ||
                            (input.charAt(i) == '}' && st.peek()  == '{') ||
                            (input.charAt(i) == ']' && st.peek()  == '[')) {
                        st.pop();
                    }
                    else  {
                        st.push(input.charAt(i));
                    }
                }
            }
            
            if(st.empty()) {
                System.out.println("true");
            }
            else {
                System.out.println("false");
            }
        }
        
    }
}




import java.util.Scanner;

public class Solution {

    static boolean isAnagram(String a, String b) {
        // Complete the function
        if(a.length() != b.length()){
            return false;
        }
        int[] freqArrA = new int[26];
        int[] freqArrB = new int[26];

        for (int i = 0; i < a.length(); i++) {
            char charA = Character.toLowerCase(a.charAt(i));
            int idx = ((int)charA) - 97;
            freqArrA[idx]++;

            char charB = Character.toLowerCase(b.charAt(i));
            idx = ((int)charB) - 97;
            freqArrB[idx]++;
        }

        for (int i = 0; i < 26; i++) {
            if (freqArrA[i] != freqArrB[i]){
                return false;
            }
        }

        return true;
    }

  public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}

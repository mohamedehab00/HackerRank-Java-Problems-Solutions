import java.util.*;

public class Solution {

    public static boolean canWin(int leap, int[] game, int x, int[] visit) {
        if (x < 0 || game[x] == 1){
            return false;
        }
        if (visit[x] == 1){
            return false;
        }
        else {
            visit[x] = 1;
        }
        if(x+leap >= game.length || x + 1 >= game.length){
            return true;
        }
        return canWin(leap,game,x-1,visit) || canWin(leap,game,x+1,visit) || canWin(leap,game,x+leap,visit);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            int[] visit = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game, 0, visit)) ? "YES" : "NO" );
        }
        scan.close();
    }
}
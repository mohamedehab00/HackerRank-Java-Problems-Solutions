import java.util.*;
public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = in.nextInt();
        int m = in.nextInt();
        int ans = 0;
        int distinct = 0;

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.addLast(num);
            int numOccur = map.getOrDefault(num,0);
            if (numOccur == 0){
                distinct++;
            }
            map.put(num,numOccur+1);

            if (deque.size() == m+1){
                int ele = deque.removeFirst();
                map.put(ele, map.get(ele)-1);
                if (map.get(ele) == 0) distinct--;
            }

            if (deque.size() == m){
                if (distinct > ans){
                    ans = distinct;
                }
            }
        }
        System.out.println(ans);
        in.close();
    }
}

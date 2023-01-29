package beijing;

import java.util.ArrayList;
import java.util.List;

public class findtheWinneroftheCircularGame {
    // 看了大佬的解答才会的，从下往上反推
    static class Solution {
        public int findTheWinner(int n, int k) {
            int pos = 0;
            for (int i = 2; i <= n; i++) {
                pos = (pos + k) % i;
            }
            return pos + 1;
        }
    }

    // 自己写的模拟
    static class Solution0 {
        public int findTheWinner(int n, int k) {
            List<Integer> list = new ArrayList<>(n);
            for (int i = 1; i <= n; i++) {
                list.add(i);
            }
            int index = 0;
            while (list.size() != 1) {
                for (int i = 1; i < k; i++) {
                    index++;
                    index = index >= list.size() ? index % list.size() : index;
                }
                list.remove(index);
            }
            return list.get(0);
        }
    }

    public static void main(String[] args) {
        int n = 6, k = 5;
        System.out.println(new Solution().findTheWinner(n, k));
    }
}

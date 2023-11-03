package beijing;
/*
https://leetcode.cn/problems/find-the-losers-of-the-circular-game/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhouhao
 * @date 2023/8/16 12:31
 */
public class CircularGameLosers {
    // 要注意下标
    static class Solution {
        public int[] circularGameLosers(int n, int k) {
            boolean[] map = new boolean[n + 1];
            int x = 0, round = 1;
            while (!map[x + 1]) {
                map[x + 1] = true;
                x = (x + (round * k)) % n;
                round++;
            }
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i < map.length; i++) {
                if (!map[i]) {
                    list.add(i);
                }
            }
            int[] ans = new int[list.size()];
            for (int i = 0; i < ans.length; i++) {
                ans[i] = list.get(i);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int n = 5, k = 2;
        System.out.println(Arrays.toString(new Solution().circularGameLosers(n, k)));
    }
}

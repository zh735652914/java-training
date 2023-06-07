package beijing;
/*
https://leetcode.cn/problems/mice-and-cheese/
 */

import java.util.Arrays;

/**
 * @author zhouhao
 * @date 2023/6/7 12:58
 */
public class MiceAndCheese {
    // 不难
    static class Solution {
        public int miceAndCheese(int[] reward1, int[] reward2, int k) {
            int[][] diff = new int[reward1.length][2];
            for (int i = 0; i < diff.length; i++) {
                diff[i][0] = reward1[i] - reward2[i];
                diff[i][1] = i;
            }
            Arrays.sort(diff, (o1, o2) -> (o2[0] - o1[0]));
            int ans = 0;
            for (int i = 0; i < diff.length; i++) {
                ans += i < k ? reward1[diff[i][1]] : reward2[diff[i][1]];
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] reward1 = {1, 1, 3, 4}, reward2 = {4, 4, 1, 1};
        int k = 2;
        System.out.println(new Solution().miceAndCheese(reward1, reward2, k));
    }
}

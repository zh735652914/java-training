package Beijing;
/*
https://leetcode.cn/problems/matchsticks-to-square/
 */

import java.util.Arrays;

// 自己不会写，这个递归后面还得多研究研究
public class makesquare {
    static class Solution {
        public boolean makesquare(int[] matchsticks) {
            int sum = 0;
            for (int x : matchsticks) {
                sum += x;
            }
            if (sum % 4 != 0) {
                return false;
            }
            int len = sum / 4;
            Arrays.sort(matchsticks);
            int[] edges = new int[4];
            return dfs(matchsticks, matchsticks.length - 1, edges, len);
        }

        private boolean dfs(int[] matchsticks, int index, int[] edges, int len) {
            if (index < 0) {
                return true;
            }
            for (int i = 0; i < edges.length; i++) {
                edges[i] += matchsticks[index];
                if (edges[i] <= len && dfs(matchsticks, index - 1, edges, len)) {
                    return true;
                }
                edges[i] -= matchsticks[index];
            }
            return false;
        }
    }

    public static void main(String[] args) {
        int[] matchsticks = {3, 3, 3, 3, 4};
        System.out.println(new Solution().makesquare(matchsticks));
    }
}

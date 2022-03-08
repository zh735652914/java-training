package Beijing;
/*
https://leetcode-cn.com/problems/plates-between-candles/
 */

public class platesBetweenCandles {
    // 自己太菜了啊
    static class Solution {
        public int[] platesBetweenCandles(String s, int[][] queries) {
            int[] ans = new int[queries.length];
            int[] preSum = new int[s.length()];
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '*') {
                    count++;
                }
                preSum[i] = count;
            }
            int[] left = new int[s.length()];
            int[] right = new int[s.length()];
            for (int i = 0, index = -1; i < left.length; i++) {
                if (s.charAt(i) == '|') {
                    index = i;
                }
                left[i] = index;
            }
            for (int i = right.length - 1, index = -1; i >= 0; i--) {
                if (s.charAt(i) == '|') {
                    index = i;
                }
                right[i] = index;
            }
            for (int i = 0; i < queries.length; i++) {
                int R = left[queries[i][1]];
                int L = right[queries[i][0]];
                if (L == -1 || R == -1 || L >= R) {
                    continue;
                }
                ans[i] = preSum[R] - preSum[L];
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        String s = "***|**|*****|**||**|*";
        int[][] queries = {{1, 17}, {4, 5}, {14, 17}, {5, 11}, {15, 16}};
        int[] ans = new Solution().platesBetweenCandles(s, queries);
        for (int an : ans) {
            System.out.print(an + ", ");
        }
    }
}

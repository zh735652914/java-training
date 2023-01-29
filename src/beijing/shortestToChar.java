package beijing;
/*
https://leetcode-cn.com/problems/shortest-distance-to-a-character/
 */

public class shortestToChar {
    // 这个我自己都没想到
    static class Solution {
        public int[] shortestToChar(String s, char c) {
            int n = s.length();
            int[] ans = new int[n];
            int index = -n;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == c) {
                    index = i;
                }
                ans[i] = Math.abs(i - index);
            }
            for (int i = n - 1; i >= 0; i--) {
                if (s.charAt(i) == c) {
                    index = i;
                }
                ans[i] = Math.min(ans[i], Math.abs(i - index));
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        char c = 'e';
        int[] ans = new Solution().shortestToChar(s, c);
        for (int x : ans) {
            System.out.print(x + ", ");
        }
    }
}

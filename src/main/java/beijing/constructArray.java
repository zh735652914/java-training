package beijing;
/*
https://leetcode.cn/problems/beautiful-arrangement-ii/
 */

public class constructArray {
    // 自己没想到怎么写
    static class Solution {
        public int[] constructArray(int n, int k) {
            int[] ans = new int[n];
            int index = 0;
            for (int i = 1; i < (n - k); i++) {
                ans[index++] = i;
            }
            for (int i = n - k, j = n; i <= j; i++, j--) {
                ans[index++] = j;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int n = 3, k = 2;
        int[] ans = new Solution().constructArray(n, k);
        for (int x : ans) {
            System.out.print(x + ", ");
        }
    }
}

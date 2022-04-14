package Beijing;
/*
https://leetcode-cn.com/problems/richest-customer-wealth/
 */

// 这种简单题没什么意义
public class maximumWealth {
    static class Solution {
        public int maximumWealth(int[][] accounts) {
            int ans = 0;
            for (int[] account : accounts) {
                int person = 0;
                for (int money : account) {
                    person += money;
                }
                ans = Math.max(ans, person);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[][] accounts = {{1, 2, 3}, {3, 2, 1}};
        System.out.println(new Solution().maximumWealth(accounts));
    }
}

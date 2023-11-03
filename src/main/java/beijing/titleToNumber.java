package beijing;
/*
https://leetcode-cn.com/problems/excel-sheet-column-number/
 */

// 简单题
public class titleToNumber {
    static class Solution {
        public int titleToNumber(String columnTitle) {
            int ans = 0;
            for (int i = 0; i < columnTitle.length(); i++) {
                ans *= 26;
                ans += columnTitle.charAt(i) - 'A' + 1;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        String columnTitle = "ZY";
        System.out.println(new Solution().titleToNumber(columnTitle));
    }
}

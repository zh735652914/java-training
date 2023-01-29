package beijing;
/*
https://leetcode.cn/problems/excel-sheet-column-number/
 */

// 的确很简单
public class ExcelSheetColumnNumber_171_topInterviewList {
    static class Solution {
        public int titleToNumber(String columnTitle) {
            int len = columnTitle.length();
            int ans = 0;
            for (int i = 0; i < len; i++) {
                ans *= 26;
                ans += (columnTitle.charAt(i) - 'A' + 1);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        String columnTitle = "ZY";
        System.out.println(new Solution().titleToNumber(columnTitle));
    }
}

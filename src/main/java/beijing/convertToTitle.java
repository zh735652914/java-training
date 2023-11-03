package beijing;
/*
https://leetcode-cn.com/problems/excel-sheet-column-title/
 */

public class convertToTitle {
    // 简单题我一开始没写出来
    static class Solution {
        public String convertToTitle(int columnNumber) {
            StringBuilder stringBuilder = new StringBuilder();
            while (columnNumber > 0) {
                columnNumber--;
                stringBuilder.append((char) (columnNumber % 26 + 'A'));
                columnNumber /= 26;
            }
            return stringBuilder.reverse().toString();
        }
    }

    public static void main(String[] args) {
        int columnNumber = 701;
        System.out.println(new Solution().convertToTitle(columnNumber));
    }
}

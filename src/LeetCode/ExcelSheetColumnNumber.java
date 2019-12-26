package LeetCode;

/*
171. Excel Sheet Column Number
Easy

707

130

Add to List

Share
Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28
    ...
Example 1:

Input: "A"
Output: 1
Example 2:

Input: "AB"
Output: 28
Example 3:

Input: "ZY"
Output: 701
 */
class ExcelSheetColumnNumberSolution {
    public int titleToNumber(String s) {
        if (s == null || s.length() < 1) return 0;
        int carry = 0, ans = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int x = s.charAt(i) - 'A' + 1;
            for (int j = 0; j < carry; j++) {
                x *= 26;
            }
            ans += x;
            carry++;
        }
        return ans;
    }
}

public class ExcelSheetColumnNumber {
    public static void main(String[] args) {
        String s = "AB";
        System.out.println(new ExcelSheetColumnNumberSolution().titleToNumber(s));
    }
}

package beijing;
/*
https://leetcode.cn/problems/bianry-number-to-string-lcci/
 */

/**
 * @author zhouhao
 * @date 2023/3/2 12:50
 */
public class PrintBin {
    // 自己没写出来
    static class Solution {
        public String printBin(double num) {
            StringBuilder ans = new StringBuilder("0.");
            while (ans.length() <= 32 && num != 0) {
                num *= 2;
                int dig = (int) num;
                ans.append(dig);
                num -= dig;
            }
            return ans.length() <= 32 ? ans.toString() : "ERROR";
        }
    }

    public static void main(String[] args) {
        double num = 0.625;
        System.out.println(new Solution().printBin(num));
    }
}

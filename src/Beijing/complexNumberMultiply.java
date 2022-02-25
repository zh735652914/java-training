package Beijing;
/*
https://leetcode-cn.com/problems/complex-number-multiplication/
 */

public class complexNumberMultiply {
    // 纯模拟就可以了
    static class Solution {
        public String complexNumberMultiply(String num1, String num2) {
            String[] A = num1.split("\\+");
            String[] B = num2.split("\\+");
            int AReal = Integer.parseInt(A[0]);
            int AImaginary = Integer.parseInt(A[1].substring(0, A[1].length() - 1));
            int BReal = Integer.parseInt(B[0]);
            int BImaginary = Integer.parseInt(B[1].substring(0, B[1].length() - 1));
            int real = AReal * BReal - AImaginary * BImaginary;
            int Imagnary = AReal * BImaginary + BReal * AImaginary;
            return real + "+" + Imagnary + "i";
//            if (real == 0 && Imagnary == 0) {
//                return "0";
//            } else if (real == 0) {
//                return Imagnary + "i";
//            } else if (Imagnary == 0) {
//                return String.valueOf(real);
//            } else {
//                return real + "+" + Imagnary + "i";
//            }
        }
    }

    public static void main(String[] args) {
        String num1 = "1+-1i", num2 = "1+-1i";
        System.out.println(new Solution().complexNumberMultiply(num1, num2));
    }
}

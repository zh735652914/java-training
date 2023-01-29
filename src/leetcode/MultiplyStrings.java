package leetcode;

/*
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Example 1:

Input: num1 = "2", num2 = "3"
Output: "6"
Example 2:

Input: num1 = "123", num2 = "456"
Output: "56088"
Note:

The length of both num1 and num2 is < 110.
Both num1 and num2 contain only digits 0-9.
Both num1 and num2 do not contain any leading zero, except the number 0 itself.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
class MultiplyStringsSolution {
    public String multiply(String num1, String num2) {
        int[] A = new int[221];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int sum = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
//                A[i + j + 1] = (sum + A[i + j + 1]) % 10;
                //顺序不能变！！！
                A[i + j] = (sum + A[i + j + 1]) / 10 + A[i + j];
                A[i + j + 1] = (sum + A[i + j + 1]) % 10;

//                int mul=(num1.charAt(i) - '0') * (num2.charAt(j) - '0');
//                int p1 = i + j, p2 = i + j + 1;
//                int sum = mul + A[p2];
////                A[p1] += sum / 10;
//                A[p2] = (sum) % 10;
//                A[p1] += sum / 10;
            }
        }
//        for (int i = 0; i <= num1.length() - 1 + num2.length(); i++) {
//            System.out.print(A[i]);
//        }
//        System.out.println("\n~~~~");
        StringBuffer ans = new StringBuffer();
        int flag = 1;
        for (int i = 0; i < num1.length() + num2.length(); i++) {
            if (A[i] == 0 && flag == 1) continue;
            flag = 0;
            ans.append(A[i]);
        }
        if (ans.length() == 0) return "0";
        return ans.toString();
    }
}

public class MultiplyStrings {
    public static void main(String[] args) {
//        String num1 = "123";
//        String num2 = "456";
        String num1 = "9";
        String num2 = "9";
        MultiplyStringsSolution MSS = new MultiplyStringsSolution();
        System.out.println(MSS.multiply(num1, num2));
    }
}

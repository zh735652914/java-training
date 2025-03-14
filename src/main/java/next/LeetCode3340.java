package next;

import org.junit.Test;

/**
 * @author zhouhao
 * @date 2025/3/14 08:55
 * https://leetcode.cn/problems/check-balanced-string/description/?envType=daily-question&envId=2025-03-14
 */
public class LeetCode3340 {
    public boolean isBalanced(String num) {
        if (num == null || num.length() < 2) {
            return false;
        }
        int oddSum = 0;
        int evenSum = 0;
        for (int i = 0; i < num.length(); i++) {
            if ((i & 1) == 0) {
                evenSum += num.charAt(i) - '0';
            } else {
                oddSum += num.charAt(i) - '0';
            }
        }
        return evenSum == oddSum;
    }

    @Test
    public void test() {
        String num = "1234";
        System.out.println(isBalanced(num));
    }
}

package beijing;
/*
https://leetcode.cn/problems/find-the-pivot-integer/
 */

/**
 * @author zhouhao
 * @date 2023/6/26 14:01
 */
public class PivotInteger {
    // 变形的数学题
    static class Solution {
        public int pivotInteger(int n) {
            int target = (1 + n) * n / 2;
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                sum += i;
                if (sum * 2 == target + i) {
                    return i;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(new Solution().pivotInteger(n));
    }
}

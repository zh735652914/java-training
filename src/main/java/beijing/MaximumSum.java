package beijing;
/*
https://leetcode.cn/problems/maximum-subarray-sum-with-one-deletion/
 */

/**
 * @author zhouhao
 * @date 2023/6/27 09:02
 */
public class MaximumSum {
    // 不会写
    static class Solution {
        public int maximumSum(int[] arr) {
            int ans = arr[0], dp0 = arr[0], dp1 = 0;
            // dp0代表之前没有删除过，dp1代表之前删除过一次
            for (int i = 1; i < arr.length; i++) {
                dp1 = Math.max(dp0, dp1 + arr[i]);
                dp0 = Math.max(dp0, 0) + arr[i];
                ans = Math.max(ans, Math.max(dp0, dp1));
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, -2, 0, 3};
        System.out.println(new Solution().maximumSum(arr));
    }
}

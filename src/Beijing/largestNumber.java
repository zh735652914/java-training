package Beijing;
/*
https://leetcode-cn.com/problems/largest-number/
 */

import java.util.Arrays;

// 这个排序得看看
public class largestNumber {
    static class Solution {
        public String largestNumber(int[] nums) {
            Integer[] N = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++) {
                N[i] = nums[i];
            }
            Arrays.sort(N, (a, b) -> {
                int x = 10;
                int y = 10;
                while (x <= a) {
                    x *= 10;
                }
                while (y <= b) {
                    y *= 10;
                }
                return -y * a - b + x * b + a;
            });
            if (N[0] == 0) {
                return "0";
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (Integer x : N) {
                stringBuilder.append(x);
            }
            return stringBuilder.toString();
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};
        System.out.println(new Solution().largestNumber(nums));
    }
}

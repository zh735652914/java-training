package beijing;
/*
https://leetcode.cn/problems/largest-number/
 */

import java.util.Arrays;

// 自己还是不会写，要注意啊！！！
public class LargestNumber_179_topInterviewList {
    static class Solution {
        public String largestNumber(int[] nums) {
            Integer[] N = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++) {
                N[i] = nums[i];
            }
            Arrays.sort(N, (a, b) -> {
                String str1 = String.valueOf(a);
                String str2 = String.valueOf(b);
                return (str2 + str1).compareTo(str1 + str2);
            });
            if (N[0] == 0) {
                return "0";
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int x : N) {
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

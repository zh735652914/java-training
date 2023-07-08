package beijing;
/*
https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/
 */

import java.util.Arrays;

/**
 * @author zhouhao
 * @date 2023/7/8 13:56
 */
public class TwoSum_167 {
    // 这题很有意思
    static class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int left = 0, right = numbers.length - 1;
            while (left < right) {
                int sum = numbers[left] + numbers[right];
                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    return new int[]{left + 1, right + 1};
                }
            }
            return new int[]{-1, -1};
        }
    }

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(new Solution().twoSum(numbers, target)));
    }
}

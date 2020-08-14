package LeetCode.ProgrammerInterview;
/*
面试题 17.04. 消失的数字
数组nums包含从0到n的所有整数，但其中缺了一个。请编写代码找出那个缺失的整数。你有办法在O(n)时间内完成吗？

注意：本题相对书上原题稍作改动

示例 1：

输入：[3,0,1]
输出：2


示例 2：

输入：[9,6,4,2,3,5,7,0,1]
输出：8
通过次数10,317提交次数15,856
 */

//这题简单到没有意义
public class missingNumber {
    static class Solution {
        public int missingNumber(int[] nums) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            int target = (1 + nums.length) * nums.length / 2;
            return target - sum;
        }
    }

    public static void main(String[] args) {
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(new Solution().missingNumber(nums));
    }
}

package leetcode.programmerInterview;
/*
面试题 17.10. 主要元素
数组中占比超过一半的元素称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。

示例 1：

输入：[1,2,5,9,5,9,5,5,5]
输出：5


示例 2：

输入：[3,2]
输出：-1


示例 3：

输入：[2,2,1,1,1,2,2]
输出：2


说明：
你有办法在时间复杂度为 O(N)，空间复杂度为 O(1) 内完成吗？

通过次数9,907提交次数15,139
 */

import java.util.Arrays;

//自己一开始想到思路没写出来，但别人写出来了，这题有点奇怪
public class majorityElement {
    static class Solution {
        public int majorityElement(int[] nums) {
            if (nums == null || nums.length == 0) {
                return -1;
            }
            Arrays.sort(nums);
            int major = nums[0];
            int count = 1;
            int max_count = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == nums[i - 1]) {
                    count++;
                } else {
                    count = 1;
                }
                if (count >= max_count) {
                    major = nums[i];
                    max_count = count;
                }
            }
            return max_count * 2 > nums.length ? major : -1;
        }
    }

    public static void main(String[] args) {
//        int[] nums = {1, 2, 5, 9, 5, 9, 5, 5, 5};
        int[] nums = {3, 2, 3};
        System.out.println(new Solution().majorityElement(nums));
    }
}

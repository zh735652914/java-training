package leetcode;
/*
https://leetcode-cn.com/problems/next-permutation/
31. 下一个排列
实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

必须 原地 修改，只允许使用额外常数空间。



示例 1：

输入：nums = [1,2,3]
输出：[1,3,2]
示例 2：

输入：nums = [3,2,1]
输出：[1,2,3]
示例 3：

输入：nums = [1,1,5]
输出：[1,5,1]
示例 4：

输入：nums = [1]
输出：[1]


提示：

1 <= nums.length <= 100
0 <= nums[i] <= 100
 */

import java.util.Arrays;

public class nextPermutation_31 {
    static class Solution {
        public void nextPermutation(int[] nums) {
            if (nums.length <= 1) {
                return;
            }
            int R = nums.length - 1;
            int L = nums.length - 2;
            while (L >= 0) {
                if (nums[L] < nums[R]) {
                    break;
                }
                L--;
                R--;
            }
            if (L < 0) {
                Arrays.sort(nums);
                return;
            }
            Arrays.sort(nums, R, nums.length);
            int pos = R;
            while (pos < nums.length) {
                if (nums[pos] > nums[L]) {
                    break;
                }
                pos++;
            }
            swap(nums, L, pos);
        }

        private void swap(int[] nums, int x, int y) {
            int tmp = nums[x];
            nums[x] = nums[y];
            nums[y] = tmp;
        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 3, 2};
        new Solution().nextPermutation(nums);
        for (int x : nums) {
            System.out.print(x + ",");
        }
    }
}

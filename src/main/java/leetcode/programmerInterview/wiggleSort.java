package leetcode.programmerInterview;
/*
面试题 10.11. 峰与谷
在一个整数数组中，“峰”是大于或等于相邻整数的元素，相应地，“谷”是小于或等于相邻整数的元素。
例如，在数组{5, 8, 6, 2, 3, 4, 6}中，{8, 6}是峰， {5, 2}是谷。现在给定一个整数数组，将该数组按峰与谷的交替顺序排序。

示例:

输入: [5, 3, 1, 2, 3]
输出: [5, 1, 3, 2, 3]
提示：

nums.length <= 10000
通过次数2,471提交次数3,768
 */

//不会写。。。
public class wiggleSort {
    static class Solution {
        public void wiggleSort(int[] nums) {
            for (int i = 1; i < nums.length; i++) {
                if (i % 2 == 0) {
                    if (nums[i] < nums[i - 1]) {
                        swap(nums, i, i - 1);
                    }
                } else {
                    if (nums[i] > nums[i - 1]) {
                        swap(nums, i, i - 1);
                    }
                }
            }
            OUTPUT(nums);
        }

        private void swap(int[] nums, int x, int y) {
            int tmp = nums[x];
            nums[x] = nums[y];
            nums[y] = tmp;
        }

        private void OUTPUT(int[] ans) {
            for (int x : ans) {
                System.out.print(x + ",");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] nums = {5, 3, 1, 2, 3};
        new Solution().wiggleSort(nums);
    }
}

package leetcode.tooffer;

import java.util.Scanner;

/*
面试题57. 和为s的两个数字
输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。



示例 1：

输入：nums = [2,7,11,15], target = 9
输出：[2,7] 或者 [7,2]
示例 2：

输入：nums = [10,26,30,31,47,60], target = 40
输出：[10,30] 或者 [30,10]


限制：

1 <= nums.length <= 10^5
1 <= nums[i] <= 10^6
通过次数5,279提交次数8,054
 */
//自己写的超时了。。。双指针的看了讨论才写出来。。。
public class twoSum {
    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            int[] ans = new int[2];
            int low = 0, high = nums.length - 1;
            while (low < high) {
                if (nums[low] + nums[high] == target) {
                    ans[0] = nums[low];
                    ans[1] = nums[high];
                    break;
                } else if (nums[low] + nums[high] > target) {
                    high--;
                } else {
                    low++;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
//        int[] nums = {2, 7, 11, 15}; int target = 9;
        Scanner scanner = new Scanner(System.in);
        String[] arr = scanner.nextLine().split(",");
        int[] nums = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nums[i] = Integer.parseInt(arr[i]);
        }
        int target = scanner.nextInt();
        int[] ans = new Solution().twoSum(nums, target);
        for (int x : ans) {
            System.out.print(x + "  ");
        }
    }
}

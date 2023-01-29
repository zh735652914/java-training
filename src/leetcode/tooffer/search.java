package leetcode.tooffer;
/*
面试题53 - I. 在排序数组中查找数字 I
统计一个数字在排序数组中出现的次数。



示例 1:

输入: nums = [5,7,7,8,8,10], target = 8
输出: 2
示例 2:

输入: nums = [5,7,7,8,8,10], target = 6
输出: 0


限制：

0 <= 数组长度 <= 50000



注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/

通过次数4,911提交次数9,610
 */

import java.util.Scanner;

public class search {
    static class Solution {
        public int search(int[] nums, int target) {
            int ans = 0;
            for (int x : nums) {
                if (x == target) ans++;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] Arr = scanner.nextLine().split(",");
        int[] nums = new int[Arr.length];
        for (int i = 0; i < Arr.length; i++) {
            nums[i] = Integer.parseInt(Arr[i]);
        }
        int target = scanner.nextInt();
        System.out.println(new Solution().search(nums, target));
    }
}

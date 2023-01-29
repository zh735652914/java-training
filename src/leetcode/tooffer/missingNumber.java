package leetcode.tooffer;
/*
面试题53 - II. 0～n-1中缺失的数字
一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。



示例 1:

输入: [0,1,3]
输出: 2
示例 2:

输入: [0,1,2,3,4,5,6,7,9]
输出: 8


限制：

1 <= 数组长度 <= 10000

通过次数5,229提交次数11,726
 */

import java.util.Scanner;

public class missingNumber {
    static class Solution {
        public int missingNumber(int[] nums) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            return (1 + nums.length) * nums.length / 2 - sum;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] Arr = scanner.nextLine().split(",");
            int[] nums = new int[Arr.length];
            for (int i = 0; i < Arr.length; i++) {
                nums[i] = Integer.parseInt(Arr[i]);
            }
            System.out.println(new Solution().missingNumber(nums));
        }
    }
}

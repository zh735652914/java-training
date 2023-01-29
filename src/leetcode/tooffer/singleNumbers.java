package leetcode.tooffer;
/*
面试题56 - I. 数组中数字出现的次数
一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。



示例 1：

输入：nums = [4,1,4,6]
输出：[1,6] 或 [6,1]
示例 2：

输入：nums = [1,2,10,4,1,4,3,3]
输出：[2,10] 或 [10,2]


限制：

2 <= nums <= 10000


通过次数3,199提交次数4,720
 */

import java.util.Scanner;

//有时间空间复杂度的要求，不会写。。。
//感觉面试的时候还是写不出来。。。
public class singleNumbers {
    static class Solution {
        public int[] singleNumbers(int[] nums) {
            int sum = 0;
            int[] ans = new int[2];
            for (int x : nums) {
                sum ^= x;
            }
            int flag = sum & (-sum);
            for (int x : nums) {
                if ((flag & x) == 0) {
                    ans[0] ^= x;
                } else {
                    ans[1] ^= x;
                }
            }
            return ans;
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
            int[] ans = new Solution().singleNumbers(nums);
            for (int x : ans) {
                System.out.print(x + ", ");
            }
            System.out.println();
        }
    }
}

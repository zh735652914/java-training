package LeetCode.ProgrammerInterview;
/*
面试题 17.19. 消失的两个数字
给定一个数组，包含从 1 到 N 所有的整数，但其中缺了两个数字。你能在 O(N) 时间内只用 O(1) 的空间找到它们吗？

以任意顺序返回这两个数字均可。

示例 1:

输入: [1]
输出: [2,3]
示例 2:

输入: [2,3]
输出: [1,4]
提示：

nums.length <= 30000
通过次数3,634提交次数6,483
 */

import java.util.Arrays;

public class missingTwo {
    static class Solution0 {
        public int[] missingTwo(int[] nums) {
            if (nums == null) {
                return new int[]{1, 2};
            }
            Arrays.sort(nums);
            int[] ans = new int[2];
            int count = 2;
            for (int i = 0, pos = 1; i < nums.length && pos <= nums.length + 2; i++, pos++) {
                if (nums[i] != pos) {
                    ans[2 - count] = pos;
                    count--;
                    i--;
                }
            }
            if (count == 1) {
                ans[1] = nums.length + 2;
            } else if (count == 2) {
                ans[0] = nums.length + 1;
                ans[1] = ans[0] + 1;
            }
            return ans;
        }
    }

    static class Solution {
        public int[] missingTwo(int[] nums) {
            int[] ans = new int[2];
            int sum = 0;
            for (int x : nums) {
                sum ^= x;
            }
            for (int i = 1; i <= nums.length + 2; i++) {
                sum ^= i;
            }
            int flag = sum & (-sum);
            for (int x : nums) {
                if ((x & flag) == 0) {
                    ans[0] ^= x;
                } else {
                    ans[1] ^= x;
                }
            }
            for (int i = 1; i <= nums.length + 2; i++) {
                if ((i & flag) == 0) {
                    ans[0] ^= i;
                } else {
                    ans[1] ^= i;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 3};
        int[] ans = new Solution().missingTwo(nums);
        for (int x : ans) {
            System.out.print(x + ",");
        }
        System.out.println();
    }
}

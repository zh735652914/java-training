package LeetCode.ToOffer;
/*
面试题59 - I. 滑动窗口的最大值
给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。

示例:

输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
输出: [3,3,5,5,6,7]
解释:

  滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7


提示：

你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。

注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/

通过次数5,221提交次数11,842
 */

import java.util.Scanner;

public class maxSlidingWindow {
    static class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums.length < 1) return nums;
            int[] ans = new int[nums.length - k + 1];
            int index = 0;
            int pos = -1;
            for (int i = 0; i < nums.length && index < ans.length; i++) {
                if (i > pos) {
                    int MAX = nums[i];
                    for (int j = i; j < i + k && j < nums.length; j++) {
                        if (nums[j] > MAX) {
                            MAX = nums[j];
                            pos = j;
                        }
                    }
                    ans[index++] = MAX;
                } else if (nums[i + k - 1] <= ans[index - 1]) {
//                    System.out.println(ans[index - 1] + "be");
                    ans[index] = ans[index - 1];
                    index++;
//                    System.out.println(ans[index ] + "af");
                } else {
                    ans[index] = nums[i + k - 1];
                    pos = i;
                    index++;
                }
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
        int[] ans = new Solution().maxSlidingWindow(nums, scanner.nextInt());
        for (int x : ans) {
            System.out.print(x + ", ");
        }
    }
}

package beijing;
/*
https://leetcode.cn/problems/missing-two-lcci/
 */

public class missingTwo {
    // 好吧，自己写过
    static class Solution {
        public int[] missingTwo(int[] nums) {
            int[] tail = new int[]{1, 1}; //n,n+1
            int n = nums.length;
            int pos = 0;
            for (int i = 0; i < n; i++) {
                pos = Math.abs(nums[i]) - 1;
                if (pos >= n) {
                    tail[pos - n] = -tail[pos - n];
                } else {
                    nums[pos] = -nums[pos];
                }
            }
            int[] ans = new int[2];
            pos = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] > 0) {
                    ans[pos++] = i + 1;
                }
            }
            for (int i = 0; i < 2; i++) {
                if (tail[i] > 0) {
                    ans[pos++] = i + 1 + n;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 3};
        int[] ans = new Solution().missingTwo(nums);
        for (int num : ans) {
            System.out.print(num + ", ");
        }
    }
}

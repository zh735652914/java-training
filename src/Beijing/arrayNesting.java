package Beijing;
/*
https://leetcode.cn/problems/array-nesting/
 */

import java.util.HashSet;
import java.util.Set;

public class arrayNesting {
    // 还是解析的方法牛逼
    static class Solution {
        public int arrayNesting(int[] nums) {
            int ans = 0;
            for (int i = 0; i < nums.length; i++) {
                int count = 0;
                while (nums[i] != -1) {
                    int next = nums[i];
                    nums[i] = -1; // 访问过的为-1；
                    count++;
                    i = next;
                }
                ans = Math.max(ans, count);
            }
            return ans;
        }
    }

    // 好吧，自己写的效率不行
    static class Solution0 {
        private int[] numLen;
        private int count;
        private int max;

        public int arrayNesting(int[] nums) {
            numLen = new int[nums.length];
            count = 0;
            max = 0;
            int ans = 0;
            for (int i = 0; i < nums.length; i++) {
                if (count == nums.length) {
                    return max;
                }
                ans = Math.max(getLen(nums, i, new HashSet<>()), ans);
            }
            return ans;
        }

        private int getLen(int[] nums, int start, Set<Integer> set) {
            if (numLen[start] != 0) {
                return numLen[start];
            }
            if (set.contains(nums[start])) {
                return 0;
            }
            set.add(nums[start]);
            numLen[start] = getLen(nums, nums[start], set) + 1;
            count++;
            max = Math.max(max, numLen[start]);
            return numLen[start];
        }
    }

    public static void main(String[] args) {
        int[] nums = {5, 4, 0, 3, 1, 6, 2};
        System.out.println(new Solution().arrayNesting(nums));
    }
}

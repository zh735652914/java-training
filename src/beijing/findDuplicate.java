package beijing;
/*
https://leetcode-cn.com/problems/find-the-duplicate-number/
 */

// 快慢指针很巧妙，都不是自己写的
public class findDuplicate {
    static class Solution {
        public int findDuplicate(int[] nums) {
            int faster = 0, slower = 0;
            while (true) {
                faster = nums[nums[faster]];
                slower = nums[slower];
                if (faster == slower) {
                    break;
                }
            }
            slower = 0;
            while (faster != slower) {
                faster = nums[faster];
                slower = nums[slower];
            }
            return slower;
        }
    }

    static class Solution0 {
        public int findDuplicate(int[] nums) {
            int[] bitMap = new int[32];
            int[] map = new int[32];
            int n = nums.length;
            for (int num : nums) {
                int index = 0;
                while (num > 0) {
                    if ((num & 1) == 1) {
                        bitMap[index]++;
                    }
                    index++;
                    num >>= 1;
                }
            }
            for (int i = 1; i < n; i++) {
                int index = 0, num = i;
                while (num > 0) {
                    if ((num & 1) == 1) {
                        map[index]++;
                    }
                    index++;
                    num >>= 1;
                }
            }
            int ans = 0;
            for (int i = 31; i >= 0; i--) {
                ans <<= 1;
                if (bitMap[i] > map[i]) {
                    ans += 1;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};
        System.out.println(new Solution().findDuplicate(nums));
    }
}

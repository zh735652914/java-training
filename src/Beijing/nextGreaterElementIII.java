package Beijing;
/*
https://leetcode.cn/problems/next-greater-element-iii/
 */

// 自己没写出来，但是还是很重要
public class nextGreaterElementIII {
    static class Solution {
        public int nextGreaterElement(int n) {
            String s = String.valueOf(n);
            int len = s.length();
            int[] nums = new int[len];
            for (int i = 0; i < len; i++) {
                nums[i] = s.charAt(i) - '0';
            }
            int x = len - 2;
            while (x >= 0) {
                if (nums[x] < nums[x + 1]) {
                    break;
                }
                x--;
            }
            if (x == -1) {
                return -1;
            }
            int y = len - 1;
            while (y > x) {
                if (nums[y] > nums[x]) {
                    break;
                }
                y--;
            }
            swap(nums, x, y);
            reverse(nums, x + 1, len - 1);
            long ans = 0;
            for (int num : nums) {
                ans *= 10;
                ans += num;
            }
            return ans > Integer.MAX_VALUE ? -1 : (int) ans;
        }

        private void swap(int[] nums, int x, int y) {
            int tmp = nums[x];
            nums[x] = nums[y];
            nums[y] = tmp;
        }

        private void reverse(int[] nums, int start, int end) {
            while (start < end) {
                swap(nums, start, end);
                start++;
                end--;
            }
        }
    }

    public static void main(String[] args) {
        int n = 4321;
        System.out.println(new Solution().nextGreaterElement(n));
    }
}

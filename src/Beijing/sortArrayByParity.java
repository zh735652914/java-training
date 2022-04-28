package Beijing;
/*
https://leetcode-cn.com/problems/sort-array-by-parity/
 */

public class sortArrayByParity {
    // 我自己一开始居然没写出来
    static class Solution {
        public int[] sortArrayByParity(int[] nums) {
            int evenIndex = nums.length - 1, oddIndex = 0;
            while (evenIndex > oddIndex) {
                while (evenIndex > oddIndex && (nums[evenIndex] & 1) == 1) {
                    evenIndex--;
                }
                while (oddIndex < evenIndex && (nums[oddIndex] & 1) == 0) {
                    oddIndex++;
                }
                if (oddIndex > evenIndex) {
                    break;
                }
                int tmp = nums[oddIndex];
                nums[oddIndex] = nums[evenIndex];
                nums[evenIndex] = tmp;
                oddIndex++;
                evenIndex--;
            }
            return nums;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2};
        int[] ans = new Solution().sortArrayByParity(nums);
        for (int x : ans) {
            System.out.print(x + ", ");
        }
    }
}

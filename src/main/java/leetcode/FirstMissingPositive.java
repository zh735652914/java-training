package leetcode;

/*
Given an unsorted integer array, find the smallest missing positive integer.

Example 1:

Input: [1,2,0]
Output: 3
Example 2:

Input: [3,4,-1,1]
Output: 2
Example 3:

Input: [7,8,9,11,12]
Output: 1
Note:

Your algorithm should run in O(n) time and uses constant extra space.
 */
/*
自己没写出来，看了discuss才写出来。。。。。。
 */
class FirstMissingPositiveSolution {
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0 || (nums.length == 1 && nums[0] < 1)) return 1;
        int[] H = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 1 || nums[i] > nums.length) continue;
            H[nums[i] - 1] = 1;
        }
        int ans = 1, flag = 1;
        for (int i = 0; i < H.length; i++) {
            if (H[i] == 0) {
                ans = i + 1;
                flag = 0;
                break;
            }
        }
        if (flag == 1) ans = H.length + 1;
        return ans;
    }
}

public class FirstMissingPositive {
    public static void main(String[] args) {
//        int[] nums = {3, 4, -1, 1};
//        int[] nums = {15, 4, 1, 5, 6, 2, -1, -2};
//        int[] nums = {1};
        int[] nums = {1, 2, 3, 4, 5, 6};
        FirstMissingPositiveSolution FMPS = new FirstMissingPositiveSolution();
        System.out.println(FMPS.firstMissingPositive(nums));
    }
}

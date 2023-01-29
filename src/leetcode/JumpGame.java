package leetcode;

/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

Example 1:

Input: [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum
             jump length is 0, which makes it impossible to reach the last index.
 */
class JumpGameSolution {
    public boolean canJump(int[] nums) {
//        int[] P=new int[nums.length];
//        int pos=0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i])
//        }
        if (nums.length <= 1) return true;
        int flag = 0, pos = 0, last = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (flag == 1) {
                if (nums[i] < pos) {
                    pos++;
                    continue;
                } else if (nums[i] > pos || (last == 1 && nums[i] >= pos)) {
                    flag = 0;
                    pos = 0;
                    last = 0;
                } else {
                    pos++;
                }
            }
            if (nums[i] == 0) {
                if (i == nums.length - 1) last = 1;
                if (flag == 1) return false;
                flag = 1;
                pos++;
            }
        }
        return flag != 1;
    }
}

public class JumpGame {
    public static void main(String[] args) {
//        int[] nums = {2, 3, 1, 1, 4};
//        int[] nums = {3, 2, 1, 0, 4};
//        int[] nums = {0};
//        int[] nums = {2, 0, 0};
        int[] nums = {1, 0, 1, 0};
        JumpGameSolution JGS = new JumpGameSolution();
        System.out.println(JGS.canJump(nums));
    }
}

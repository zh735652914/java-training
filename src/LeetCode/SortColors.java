package LeetCode;

/*
Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: You are not suppose to use the library's sort function for this problem.

Example:

Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Follow up:

A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
Could you come up with a one-pass algorithm using only constant space?
 */
/*
自己一开始没想出来，但是看了discuss后感觉很厉害
 */
class SortColorsSolution {
    public void sortColors(int[] nums) {
        int pos = 0, p1 = 0, p2 = nums.length - 1;
        while (pos <= p2) {
            if (nums[pos] == 0) {
                nums[pos] = nums[p1];
                nums[p1] = 0;
                p1++;
            }
            if (nums[pos] == 2) {
                nums[pos] = nums[p2];
                nums[p2] = 2;
                p2--;
                pos--;
            }
            pos++;
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}

public class SortColors {
    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        SortColorsSolution SC = new SortColorsSolution();
        SC.sortColors(nums);
    }
}

package leetcode;
/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
 */


import java.util.Arrays;

class NextPermutationSolution {
    public void nextPermutation(int[] nums) {
        int q = nums.length - 1;
        int p = nums.length - 2;
        while (p >= 0) {
            if (nums[p] < nums[q]) break;
            p--;
            q--;
        }
        if (p < 0) {
            Arrays.sort(nums);
        } else {
            Arrays.sort(nums, q, nums.length);
//            for (int i = 0; i < nums.length; i++) {
//                System.out.print(nums[i] + "***");
//            }
//            System.out.println("");
            int pos = p;
            for (int i = q; i < nums.length; i++) {
                if (nums[pos] < nums[i]) {
                    pos = i;
                    break;
                }
            }

            int tmp = nums[pos];
            nums[pos] = nums[p];
            nums[p] = tmp;
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "->");
        }
    }
}

public class NextPermutation {
    public static void main(String[] args) {
//        int[] nums = {1, 3, 4, 2};
        int[] nums = {1, 2, 4, 3};
        NextPermutationSolution NPS = new NextPermutationSolution();
        NPS.nextPermutation(nums);
    }
}

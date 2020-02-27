package LeetCode.ToOffer;

import java.util.Arrays;
import java.util.Scanner;

public class twoSum {
    static class Solution {
        public int[] twoSum(int[] nums, int target) {
//            Arrays.sort(nums);
            int[] ans = new int[2];
            for (int i = 0; i < nums.length - 1; i++) {
                int found = target - nums[i];
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] == found) {
                        ans[0] = i;
                        ans[1] = j;
                        return ans;
                    }
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
//        int[] nums = {2, 7, 11, 15}; int target = 9;
        Scanner scanner = new Scanner(System.in);
        String[] arr = scanner.nextLine().split(",");
        int[] nums = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nums[i] = Integer.parseInt(arr[i]);
        }
        int target = scanner.nextInt();
        int[] ans = new Solution().twoSum(nums, target);
        for (int x : ans) {
            System.out.print(x + "  ");
        }
    }
}

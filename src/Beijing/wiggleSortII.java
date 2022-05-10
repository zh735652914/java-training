package Beijing;
/*
https://leetcode.cn/problems/wiggle-sort-ii/
 */

// 这题得看看，自己不会写，而且写法需要注意！！！
public class wiggleSortII {
    static class Solution {
        public void wiggleSort(int[] nums) {
            int[] bucket = new int[5001];
            for (int num : nums) {
                bucket[num]++;
            }
            int index = bucket.length - 1;
            for (int i = 1; i < nums.length; i += 2) {
                while (index >= 0 && bucket[index] == 0) {
                    index--;
                }
                nums[i] = index;
                bucket[index]--;
            }
            for (int i = 0; i < nums.length; i += 2) {
                while (index >= 0 && bucket[index] == 0) {
                    index--;
                }
                nums[i] = index;
                bucket[index]--;
            }
        }
    }

    public static void main(String[] args) {
//        int[] nums = {1, 5, 1, 1, 6, 4};
        int[] nums = {4, 5, 5, 6};
        new Solution().wiggleSort(nums);
        for (int num : nums) {
            System.out.print(num + ", ");
        }
    }
}

package beijing.hot100;
/*
https://leetcode.cn/problems/next-permutation/
 */

// 看了官方解答才写出来，官方解析还是牛逼
public class nextPermutation_31 {
    static class Solution {
        public void nextPermutation(int[] nums) {
            int index = nums.length - 1;
            while (index > 0) {
                if (nums[index - 1] < nums[index]) {
                    int pos = nums.length - 1;
                    while (pos >= index) {
                        if (nums[pos] > nums[index - 1]) {
                            swap(nums, pos, index - 1);
                            break;
                        }
                        pos--;
                    }
                    break;
                }
                index--;
            }
            reverse(nums, index);
        }

        private void reverse(int[] nums, int start) {
            int left = start, right = nums.length - 1;
            while (left < right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }

        private void swap(int[] nums, int indexA, int indexB) {
            int tmp = nums[indexA];
            nums[indexA] = nums[indexB];
            nums[indexB] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2};
        new Solution().nextPermutation(nums);
        for (int num : nums) {
            System.out.print(num + ", ");
        }
    }
}

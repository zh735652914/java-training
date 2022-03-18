package Beijing;
/*
https://leetcode-cn.com/problems/sort-colors/
 */

public class sortColors {
    static class Solution {
        public void sortColors(int[] nums) {
            int index = 0, left = 0, right = nums.length - 1;
            while (index <= right) {
                // 这个是重点，并且，while和if的顺序不能换
                while (index <= right && nums[index] == 2) {
                    swap(nums, right, index);
                    right--;
                }
                // 如果交换完不是1，开始对下一个数据进行交换，如果没有下面的if，就会报错
                if (nums[index] == 0) {
                    swap(nums, left, index);
                    left++;
                }
                index++;
            }
        }

        private void swap(int[] nums, int x, int y) {
            int tmp = nums[x];
            nums[x] = nums[y];
            nums[y] = tmp;
        }
    }

    // 自己写的，但是代码可能要优化一下
    static class Solution0 {
        public void sortColors(int[] nums) {
            int last = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    if (last == i) {
                        last = i + 1;
                        continue;
                    }
                    int newP = searchPos(nums, 0, last);
                    if (newP == -1) {
                        continue;
                    }
                    swap(nums, i, newP);
                    last = newP;
                }
            }
            last = nums.length - 1;
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] == 2) {
                    if (last == i) {
                        last = i - 1;
                        continue;
                    }
                    int newP = searchPos(nums, 2, last);
                    if (newP == -1) {
                        continue;
                    }
                    swap(nums, i, newP);
                    last = newP;
                }
            }
        }

        private int searchPos(int[] nums, int x, int start) {
            if (x == 0) {
                for (int i = start; i < nums.length; i++) {
                    if (nums[i] != x) {
                        return i;
                    }
                }
            } else if (x == 2) {
                for (int i = start; i >= 0; i--) {
                    if (nums[i] != x) {
                        return i;
                    }
                }
            }
            return -1;
        }

        private void swap(int[] nums, int x, int y) {
            int tmp = nums[x];
            nums[x] = nums[y];
            nums[y] = tmp;
        }
    }

    public static void main(String[] args) {
//        int[] nums = {2, 0, 2, 1, 1, 0};
        int[] nums = {1, 2, 0};
//        int[] nums = {0, 0, 1};
        new Solution().sortColors(nums);
        for (int num : nums) {
            System.out.print(num + ", ");
        }
    }
}

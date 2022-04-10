package Beijing;
/*
https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 */

public class TwoSumII {
    // 还是双指针快
    static class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int left = 0, right = numbers.length - 1;
            while (left < right) {
                int sum = numbers[left] + numbers[right];
                if (sum == target) {
                    return new int[]{left + 1, right + 1};
                }
                if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
            return new int[]{-1, -1};
        }
    }

    // 二分查找
    static class Solution1 {
        public int[] twoSum(int[] numbers, int target) {
            for (int i = 0; i < numbers.length - 1; i++) {
                int left = i + 1, right = numbers.length - 1;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (numbers[mid] == target - numbers[i]) {
                        return new int[]{i + 1, mid + 1};
                    }
                    if (numbers[mid] < target - numbers[i]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }
            return new int[]{-1, -1};
        }
    }

    // 效率太低了
    static class Solution0 {
        public int[] twoSum(int[] numbers, int target) {
            for (int i = 0; i < numbers.length - 1; i++) {
                for (int j = i + 1; j < numbers.length; j++) {
                    int sum = numbers[i] + numbers[j];
                    if (sum == target) {
                        return new int[]{i + 1, j + 1};
                    } else if (sum > target) {
                        break;
                    }
                }
            }
            return new int[]{-1, -1};
        }
    }

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] ans = new Solution().twoSum(numbers, target);
        System.out.println(ans[0] + ", " + ans[1]);
    }
}

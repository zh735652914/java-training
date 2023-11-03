package beijing;
/*
https://leetcode.cn/problems/shortest-subarray-to-be-removed-to-make-array-sorted/
 */

/**
 * @author zhouhao
 * @date 2023/3/25 12:49
 */
public class FindLengthOfShortestSubarray {
    // 自己没写出来
    static class Solution {
        public int findLengthOfShortestSubarray(int[] arr) {
            int left = 0, right = arr.length - 1;
            while (left < arr.length - 1 && arr[left + 1] >= arr[left]) {
                left++;
            }
            if (left == arr.length - 1) {
                return 0;
            }
            int ans = arr.length - left - 1;
            while (right >= 0 && right >= left) {
                while (left >= 0 && arr[left] > arr[right]) {
                    left--;
                }
                ans = Math.min(ans, right - left - 1);
                if (right - 1 >= 0 && arr[right - 1] > arr[right]) {
                    break;
                }
                right--;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 10, 4, 2, 3, 5};
        System.out.println(new Solution().findLengthOfShortestSubarray(arr));
    }
}

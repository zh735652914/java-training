package beijing;
/*
https://leetcode.cn/problems/find-k-closest-elements/
 */

import java.util.ArrayList;
import java.util.List;

public class findClosestElements {
    // 自己没写出来，而且二分中mid的计算用位运算的话，需要注意
    static class Solution {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            List<Integer> ans = new ArrayList<>(k);
            int right = binarySearch(arr, x);
            int left = right - 1;
            while (k-- > 0) {
                if (left < 0) {
                    right++;
                } else if (right >= arr.length) {
                    left--;
                } else if ((x - arr[left]) <= (arr[right] - x)) {
                    left--;
                } else {
                    right++;
                }
            }
            for (int i = left + 1; i < right; i++) {
                ans.add(arr[i]);
            }
            return ans;
        }

        private int binarySearch(int[] arr, int x) {
            int low = 0, high = arr.length - 1;
            while (low < high) {
                int mid = low + ((high - low) >> 1);
                System.out.println(mid);
                if (arr[mid] >= x) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 10, 10, 10};
        int k = 1, x = 9;
        System.out.println(new Solution().findClosestElements(arr, k, x));
    }
}

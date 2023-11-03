package beijing;
/*
https://leetcode.cn/problems/max-chunks-to-make-sorted/
 */

// 自己想不到
public class maxChunksToSorted {
    static class Solution {
        public int maxChunksToSorted(int[] arr) {
            int count = 0, num = 0;
            for (int i = 0; i < arr.length; i++) {
                num = Math.max(num, arr[i]);
                if (num == i) {
                    count++;
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 3, 4};
        System.out.println(new Solution().maxChunksToSorted(arr));
    }
}

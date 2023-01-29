package leetcode.programmerInterview;
/*
面试题 17.14. 最小K个数
设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。

示例：

输入： arr = [1,3,5,7,2,4,6,8], k = 4
输出： [1,2,3,4]
提示：

0 <= len(arr) <= 100000
0 <= k <= min(100000, len(arr))
通过次数11,340提交次数20,410
 */


import java.util.PriorityQueue;

public class smallestK {
    static class Solution {
        public int[] smallestK(int[] arr, int k) {
            if (arr == null || arr.length == 0) {
                return new int[k];
            }
            int[] ans = new int[k];
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for (int j : arr) {
                queue.offer(j);
            }
            for (int i = 0; i < k && !queue.isEmpty(); i++) {
                ans[i] = queue.poll();
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 2, 4, 6, 8};
        int k = 4;
        int[] ans = new Solution().smallestK(arr, k);
        for (int x : ans) {
            System.out.print(x + ",");
        }
        System.out.println();
    }
}

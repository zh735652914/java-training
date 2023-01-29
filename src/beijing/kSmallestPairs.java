package beijing;
/*
https://leetcode-cn.com/problems/find-k-pairs-with-smallest-sums/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class kSmallestPairs {
    static class Solution {

        // 这个不是自己写的，自己不会写
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            List<List<Integer>> ans = new ArrayList<>(k);
            PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> (nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]]));
            for (int i = 0; i < Math.min(k, nums1.length); i++) {
                priorityQueue.offer(new int[]{i, 0});
            }
            while (k-- > 0 && !priorityQueue.isEmpty()) {
                int[] pos = priorityQueue.poll();
                ans.add(Arrays.asList(nums1[pos[0]], nums2[pos[1]]));
                if (++pos[1] < nums2.length) {
                    priorityQueue.offer(pos);
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 2}, nums2 = {1, 2, 3};
        int k = 10;
        System.out.println(new Solution().kSmallestPairs(nums1, nums2, k));
    }
}

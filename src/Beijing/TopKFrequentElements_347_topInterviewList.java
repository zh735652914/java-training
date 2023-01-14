package Beijing;
/*
https://leetcode.cn/problems/top-k-frequent-elements/
 */

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author zhouhao
 * @date 2023/1/14 17:21
 */
// 这个调用排序有点忘记了
public class TopKFrequentElements_347_topInterviewList {
    static class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            PriorityQueue<int[]> queue = new PriorityQueue<>(((o1, o2) -> (o2[1] - o1[1])));
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int num = entry.getKey();
                int count = entry.getValue();
                queue.offer(new int[]{num, count});
            }
            int[] ans = new int[k];
            for (int i = 0; i < k; i++) {
                ans[i] = queue.poll()[0];
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] ans = new Solution().topKFrequent(nums, k);
        for (int x : ans) {
            System.out.print(x + ", ");
        }
    }
}

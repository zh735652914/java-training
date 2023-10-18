package beijing;
/*
https://leetcode.cn/problems/maximal-score-after-applying-k-operations/?envType=daily-question&envId=2023-10-18
 */

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author zhouhao
 * @date 2023/10/18 12:52
 */
public class MaxKelements {
    static class Solution {
        public long maxKelements(int[] nums, int k) {
            PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
            for (int num : nums) {
                queue.offer(num);
            }
            long ans = 0;
            while (k-- > 0) {
                ans += queue.peek();
                int next = (queue.poll() + 2) / 3;
                queue.offer(next);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {10, 10, 10, 10, 10};
        int k = 5;
        System.out.println(new Solution().maxKelements(nums, k));
    }
}

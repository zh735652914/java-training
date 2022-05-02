package Beijing;
/*
https://leetcode-cn.com/problems/top-k-frequent-elements/
 */

import java.util.HashMap;
import java.util.Map;

// 看了别人写的解法，真牛逼
public class topKFrequent {
    static class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            int[] ans = new int[k];
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            int maxCount = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                maxCount = Math.max(maxCount, entry.getValue());
            }
            int index = 0;
            while (index < ans.length) {
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    if (entry.getValue() == maxCount) {
                        ans[index++] = entry.getKey();
                    }
                }
                maxCount--;
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

package beijing;
/*
https://leetcode.cn/problems/most-frequent-even-element/
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhouhao
 * @date 2023/4/13 14:06
 */
public class MostFrequentEven {
    // 的确很简单
    static class Solution {
        public int mostFrequentEven(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                if ((num & 1) == 0) {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                }
            }
            if (map.isEmpty()) {
                return -1;
            }
            int ans = Integer.MAX_VALUE, count = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() > count || entry.getValue() == count && entry.getKey() < ans) {
                    ans = entry.getKey();
                    count = entry.getValue();
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 4, 4, 1};
        System.out.println(new Solution().mostFrequentEven(nums));
    }
}

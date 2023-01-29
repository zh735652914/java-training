package beijing.hot100;
/*
https://leetcode.cn/problems/top-k-frequent-elements/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// 自己写的，但是没有别的写的简洁
public class topKFrequentElements_347 {
    static class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            int[] count = new int[map.size()];
            int pos = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                count[pos++] = entry.getValue();
            }
            Arrays.sort(count);
            Set<Integer> set = new HashSet<>();
            for (int i = count.length - 1; i > count.length - k - 1; i--) {
                set.add(count[i]);
            }
            List<Integer> list = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (set.contains(entry.getValue())) {
                    list.add(entry.getKey());
                }
            }
            int[] ans = new int[list.size()];
            for (int i = 0; i < ans.length; i++) {
                ans[i] = list.get(i);
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

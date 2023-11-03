package beijing;
/*
https://leetcode.cn/problems/sort-array-by-increasing-frequency/
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class frequencySort {
    // 自己没写出来
    static class Solution {
        public int[] frequencySort(int[] nums) {
            Map<Integer, Integer> cnt = new HashMap<>();
            for (int num : nums) {
                cnt.put(num, cnt.getOrDefault(num, 0) + 1);
            }
            List<Integer> list = new ArrayList<Integer>();
            for (int num : nums) {
                list.add(num);
            }
            list.sort((a, b) -> {
                int cnt1 = cnt.get(a), cnt2 = cnt.get(b);
                return cnt1 != cnt2 ? cnt1 - cnt2 : b - a;
            });
            int[] ans = new int[nums.length];
            for (int i = 0; i < ans.length; i++) {
                ans[i] = list.get(i);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 3};
        int[] ans = new Solution().frequencySort(nums);
        for (int num : ans) {
            System.out.print(num + ", ");
        }
    }
}

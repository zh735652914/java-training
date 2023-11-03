package beijing;
/*
https://leetcode.cn/problems/largest-values-from-labels/
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhouhao
 * @date 2023/5/23 12:58
 */
public class LargestValsFromLabels {
    // 主要是排序
    static class Solution {
        public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
            Integer[] id = new Integer[values.length];
            for (int i = 0; i < id.length; i++) {
                id[i] = i;
            }
            Arrays.sort(id, (a, b) -> (values[b] - values[a]));
            int ans = 0, choose = 0;
            Map<Integer, Integer> cnt = new HashMap<>();
            for (int i = 0; i < id.length && choose < numWanted; i++) {
                if (cnt.getOrDefault(labels[id[i]], 0) >= useLimit) {
                    continue;
                }
                ans += values[id[i]];
                cnt.put(labels[id[i]], cnt.getOrDefault(labels[id[i]], 0) + 1);
                choose++;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] values = {5, 4, 3, 2, 1}, labels = {1, 1, 2, 2, 3};
        int numWanted = 3, useLimit = 1;
        System.out.println(new Solution().largestValsFromLabels(values, labels, numWanted, useLimit));
    }
}

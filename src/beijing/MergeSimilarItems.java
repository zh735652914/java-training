package beijing;
/*
https://leetcode.cn/problems/merge-similar-items/
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouhao
 * @date 2023/2/28 13:12
 */
public class MergeSimilarItems {
    // 简单题
    static class Solution {
        public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
            int[] map = new int[1001];
            for (int[] item : items1) {
                map[item[0]] += item[1];
            }
            for (int[] item : items2) {
                map[item[0]] += item[1];
            }
            List<List<Integer>> ans = new ArrayList<>();
            for (int i = 1; i < map.length; i++) {
                if (map[i] == 0) {
                    continue;
                }
                List<Integer> x = new ArrayList<>();
                x.add(i);
                x.add(map[i]);
                ans.add(x);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[][] items1 = {{1, 1}, {4, 5}, {3, 8}}, items2 = {{3, 1}, {1, 5}};
        System.out.println(new Solution().mergeSimilarItems(items1, items2));
    }
}

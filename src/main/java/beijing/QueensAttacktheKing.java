package beijing;
/*
https://leetcode.cn/problems/queens-that-can-attack-the-king/?envType=daily-question&envId=2023-09-14
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhouhao
 * @date 2023/9/14 17:30
 */
public class QueensAttacktheKing {
    // 看了解析才勉强写出来
    static class Solution {
        public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
            List<List<Integer>> ans = new ArrayList<>();
            Map<Integer, int[]> map = new HashMap<>();
            for (int[] queen : queens) {
                if (queen[0] == king[0] || queen[1] == king[1] || Math.abs(queen[0] - king[0]) == Math.abs(queen[1] - king[1])) {
                    int dir = fun(queen[0] - king[0]) + 10 * fun(queen[1] - king[1]);
                    if (!map.containsKey(dir) || map.get(dir)[2] > Math.abs(queen[0] - king[0]) + Math.abs(queen[1] - king[1])) {
                        map.put(dir, new int[]{queen[0], queen[1], Math.abs(queen[0] - king[0]) + Math.abs(queen[1] - king[1])});
                    }
                }
            }
            for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
                List<Integer> aAns = new ArrayList<>();
                aAns.add(entry.getValue()[0]);
                aAns.add(entry.getValue()[1]);
                ans.add(aAns);
            }
            return ans;
        }

        private int fun(int x) {
            if (x > 0) {
                return 1;
            } else if (x < 0) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] queens = {
                {0, 0},
                {1, 1},
                {2, 2},
                {3, 4},
                {3, 5},
                {4, 4},
                {4, 5}
        };
        int[] king = {3, 3};
        System.out.println(new Solution().queensAttacktheKing(queens, king));
    }
}

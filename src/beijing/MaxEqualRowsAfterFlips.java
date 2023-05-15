package beijing;
/*
https://leetcode.cn/problems/flip-columns-for-maximum-number-of-equal-rows/
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhouhao
 * @date 2023/5/15 13:00
 */
public class MaxEqualRowsAfterFlips {
    // 看了解析才会
    static class Solution {
        public int maxEqualRowsAfterFlips(int[][] matrix) {
            /*
            如果让一行数据成为相同的数据，则和其相同的行以及完全取反的行也会达到同样的目的
             */
            Map<String, Integer> map = new HashMap<>();
            for (int[] row : matrix) {
                char[] R = new char[row.length];
                for (int i = 0; i < row.length; i++) {
                    R[i] = (char) (row[0] ^ row[i]);
                }
                String key = new String(R);
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            int ans = 0;
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                ans = Math.max(ans, entry.getValue());
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 0, 0},
                {0, 0, 1},
                {1, 1, 0}
        };
        System.out.println(new Solution().maxEqualRowsAfterFlips(matrix));
    }
}

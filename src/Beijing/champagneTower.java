package Beijing;
/*
https://leetcode.cn/problems/champagne-tower/
 */

public class champagneTower {
    // 模拟，好像也不太好模拟
    static class Solution {
        public double champagneTower(int poured, int query_row, int query_glass) {
            double[] row = {poured};
            for (int i = 1; i <= query_row; i++) {
                double[] nextRow = new double[i + 1];
                for (int j = 0; j < i; j++) {
                    double volume = row[j];
                    if (volume > 1) {
                        nextRow[j] += (volume - 1) / 2;
                        nextRow[j + 1] += (volume - 1) / 2;
                    }
                }
                row = nextRow;
            }
            return Math.min(1, row[query_glass]);
        }
    }

    public static void main(String[] args) {
        int poured = 2, query_row = 1, query_glass = 1;
        System.out.println(new Solution().champagneTower(poured, query_row, query_glass));
    }
}

package beijing;

/**
 * @author zhouhao
 * @date 2023/8/11 12:42
 */
public class DiagonalSum {
    // 很简单
    static class Solution {
        public int diagonalSum(int[][] mat) {
            int sum = 0;
            for (int i = 0; i < mat.length; i++) {
                sum += mat[i][i];
            }
            int x = 0, y = mat[0].length - 1;
            while (x < mat.length && y >= 0) {
                if (x == y) {
                    x++;
                    y--;
                    continue;
                }
                sum += mat[x++][y--];
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        int[][] mat = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(new Solution().diagonalSum(mat));
    }
}

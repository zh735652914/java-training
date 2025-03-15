package next;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author zhouhao
 * @date 2025/3/15 17:20
 * https://leetcode.cn/problems/rotate-image/description/
 */
public class LeetCode48 {
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix[0].length / 2; i++) {
            for (int j = 0; j < matrix.length; j++) {
                swap(matrix, j, i, j, matrix[0].length - 1 - i);
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length - i; j++) {
                swap(matrix, i, j, matrix.length - 1 - j, matrix[0].length - 1 - i);
            }
        }
        // (0,1)->(1,2)
    }

    private void swap(int[][] matrix, int x1, int y1, int x2, int y2) {
        int tmp = matrix[x1][y1];
        matrix[x1][y1] = matrix[x2][y2];
        matrix[x2][y2] = tmp;
    }

    @Test
    public void test() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(matrix);
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}

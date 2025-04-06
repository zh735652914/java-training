package next;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author zhouhao
 * @date 2025/4/6 09:45
 * https://leetcode.cn/problems/search-a-2d-matrix-ii/
 */
public class LeetCode240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int x = 0, y = matrix[0].length - 1;
        while (x < matrix.length && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] < target) {
                x++;
            } else {
                y--;
            }
        }
        return false;
    }

    @Test
    public void test() {
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int target = 5;
        assertTrue(searchMatrix(matrix, target));
    }
}

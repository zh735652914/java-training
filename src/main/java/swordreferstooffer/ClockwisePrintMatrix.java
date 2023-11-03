package swordreferstooffer;

import java.util.ArrayList;

/*
题目描述
输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
class ClockwisePrintMatrixSolution {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> ans = new ArrayList<>();
        int up = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        while (true) {
            for (int i = left; i <= right; i++) {
                ans.add(matrix[up][i]);
            }
            if (++up > down) {
                break;
            }
            for (int i = up; i <= down; i++) {
                ans.add(matrix[i][right]);
            }
            if (--right < left) {
                break;
            }
            for (int i = right; i >= left; i--) {
                ans.add(matrix[down][i]);
            }
            if (--down < up) {
                break;
            }
            for (int i = down; i >= up; i--) {
                ans.add(matrix[i][left]);
            }
            if (++left > right) {
                break;
            }
        }
        return ans;
    }
}

public class ClockwisePrintMatrix {
    public static void main(String[] args) {
        ClockwisePrintMatrixSolution CPMS = new ClockwisePrintMatrixSolution();
//        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8, 10}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] matrix = {{1, 2}, {3,4}};
//        System.out.println("!"+matrix.length);
//        System.out.println(("*"+matrix[0].length));
        System.out.println(CPMS.printMatrix(matrix));
    }
}

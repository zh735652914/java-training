package Interview;

import java.util.Arrays;
import java.util.Scanner;

public class huawei_bishi3 {
    public static void solution(int[][] matrix) {
        int[] nums = new int[matrix.length * matrix[0].length];
        int index = 0;
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                nums[index++] = anInt;
            }
        }
        Arrays.sort(nums);
        int[][] ans = new int[matrix.length][matrix[0].length];
        int r_start = 0, r_end = matrix.length - 1, c_start = 0, c_end = matrix[0].length - 1;
        index = 0;
        while (r_start <= r_end && c_start <= c_end) {
            for (int i = c_start; i <= c_end && index < nums.length; i++) {
                ans[r_start][i] = nums[index++];
            }
            r_start++;
            if (r_start > r_end) {
                break;
            }
            for (int i = r_start; i <= r_end; i++) {
                ans[i][c_end] = nums[index++];
            }
            c_end--;
            if (c_end < c_start) {
                break;
            }
            for (int i = c_end; i >= c_start; i--) {
                ans[r_end][i] = nums[index++];
            }
            r_end--;
            if (r_end < r_start) {
                break;
            }
            for (int i = r_end; i >= r_start; i--) {
                ans[i][c_start] = nums[index++];
            }
            c_start++;
            if (c_start > c_end) {
                break;
            }

        }
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        solution(matrix);
    }
}

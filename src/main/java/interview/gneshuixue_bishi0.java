package interview;

import java.util.Scanner;

public class gneshuixue_bishi0 {
    public static void solution(int[][] matrix, int n) {
        int[] tmp = new int[n];
        int top = 0, down = n - 1;
        while (top < down) {
            System.arraycopy(matrix[down], 0, tmp, 0, n);

            for (int i = 0; i < tmp.length; i++) {
                matrix[down][i] = matrix[top][n - i - 1];
            }
            for (int i = 0; i < tmp.length; i++) {
                matrix[top][i] = tmp[n - i - 1];
            }
            top++;
            down--;
        }

        if (top == down) {
            System.arraycopy(matrix[top], 0, tmp, 0, n);
            for (int i = 0; i < n; i++) {
                matrix[top][i] = tmp[n - i - 1];
            }
        }

        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        solution(matrix, n);
    }
}

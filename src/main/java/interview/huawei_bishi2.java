package interview;

import java.util.Scanner;

public class huawei_bishi2 {
    int M, N;
    int[][] mat;
    int ans;
    int[] xdir = {0, 0, 1, -1, 0};
    int[] ydir = {1, -1, 0, 0, 0};
    int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

    public void solution(int M, int N, int[][] mat) {
        this.M = M;
        this.N = N;
        this.mat = mat;
    }

    private int ok(int i, int j, int x, int y) {
        if (i >= 0 && i < 3 && j >= 0 && j < 3 && mat[x][y] != 1) {
            return 1;
        }
        return 0;
    }

    public void dfs(int cur, int kk, int nowi, int nowj) {
        if (kk == M) {
            ans = Math.max(ans, cur);
            return;
        }
        for (int i = nowi; i < 3; i++) {
            for (int j = nowj; j < 3; j++) {
                for (int k = 0; k < 5; k++) {
                    int nxt_x = i + xdir[k];
                    int nxt_y = j + ydir[k];
//                    if (ok(nxt_x, nxt_y, ))
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int[][] mat = new int[M][2];
        for (int i = 0; i < M; i++) {
            mat[i][0] = scanner.nextInt();
            mat[i][1] = scanner.nextInt();
        }
        int N = scanner.nextInt();
        new huawei_bishi2().solution(M, N, mat);
    }
}

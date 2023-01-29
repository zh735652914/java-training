package interview;

import java.util.Arrays;
import java.util.Scanner;

public class huawei_bishi5 {

    boolean[][] g;
    boolean[] visited;
    int[] linker;

    public void solution(int n, int m, int[][] matrix) {
        g = new boolean[n + 1][n + 1];
        visited = new boolean[n + 1];
        linker = new int[n + 1];
        for (int i = 0; i < matrix.length; i++) {
            g[matrix[i][0]][matrix[i][1]] = true;
        }
        int ans = find(n, m);
        System.out.println(ans);
    }

    private int find(int n, int m) {
        Arrays.fill(linker, -1);
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            Arrays.fill(visited, false);
            if (dfs(i, n)) {
                ans++;
            }
        }
        return ans;
    }

    private boolean dfs(int pos, int n) {
        for (int i = 1; i <= n; i++) {
            if (g[pos][i] && !visited[i]) {
                visited[i] = true;
                if (linker[i] == 0 || dfs(linker[i], n)) {
                    linker[i] = pos;
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] matrix = new int[m][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 2; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        new huawei_bishi5().solution(n, m, matrix);
    }
}

//    static class city {
//        int name;
//        List<city> canVisit;
//
//        city(int name) {
//            this.name = name;
//        }
//
//        city(int name, List<city> canVisit) {
//            this.name = name;
//            this.canVisit = canVisit;
//        }
//    }
//
//    boolean[][] road;
//    int min;
//
//    public void solution(int n, int m, int[][] matrix) {
//        road = new boolean[n][n];
//        min = m;
//
//        Map<Integer, List<Integer>> map = new HashMap<>();
//
//    }
//
//    private void dfs(boolean[][] canVisit, int index, int[][] matrix, int count) {
//        if (isOK(canVisit)) {
//            min = Math.min(min, count);
//            return;
//        }
//        count++;
//        canVisit[matrix[index][0]][matrix[index][1]] = true;
//
//    }
//
//    private boolean isOK(boolean[][] canVisit) {
//
//
//
//
//        boolean[][] allVisit = canVisit.clone();
//        for (int i = 0; i <; i++) {
//
//        }
//        for (int i = 0; i < road.length; i++) {
//            for (int j = 0; j < road[i].length; j++) {
//                if (road[i][j] && !canVisit[i][j]) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
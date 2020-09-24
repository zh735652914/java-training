package Interview;

import java.util.Scanner;

public class jingdong_bishi1 {
    boolean[][] visited;
    static int[][] drcs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public void solution(int n, int m, char[][] map) {
        int start = 0, end = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'S') {
                    start = i;
                    end = j;
                }
            }
        }
        visited = new boolean[n][m];
        if (dfs(start, end, map)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private boolean dfs(int x, int y, char[][] map) {
        if (x < 0 || x >= map.length || y < 0 || y >= map[0].length || visited[x][y] || map[x][y] == '#') {
            return false;
        }
        visited[x][y] = true;
        if (map[x][y] == 'E') {
            return true;
        }
//        boolean res = false;
//        for (int[] drc : drcs) {
//            res = res || dfs(x + drc[0], y + drc[1], map);
//        }
        boolean res = dfs(x + 1, y, map) || dfs(x - 1, y, map) || dfs(x, y + 1, map) || dfs(x, y - 1, map);
        visited[x][y] = false;
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        jingdong_bishi1 obj = new jingdong_bishi1();
        while (x-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            scanner.nextLine();
            char[][] map = new char[n][m];
            for (int i = 0; i < n; i++) {
                String s = scanner.nextLine();
                for (int j = 0; j < m; j++) {
                    map[i][j] = s.charAt(j);
                }
            }
            obj.solution(n, m, map);
        }
    }
}

package interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class jianhang_bishi1 {
    static public class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         * 寻找朋友总数
         *
         * @param M int整型二维数组
         * @return int整型
         */
        public int findFriendNum0(int[][] M) {
            int res = 0;
            if (M.length == 0 || M[0].length == 0) {
                return 0;
            }
            Queue<int[]> queue = new LinkedList<>();
            boolean[][] visited = new boolean[M.length][M[0].length];
            int[] L = {0, 1, 0, -1};
            int[] R = {1, 0, -1, 0};
            for (int i = 0; i < M.length; i++) {
                for (int j = 0; j < M[i].length; j++) {
                    if (!visited[i][j] && M[i][j] == 1) {
                        queue.add(new int[]{i, j});
                        visited[i][j] = true;
                        visited[j][i] = true;
                        while (!queue.isEmpty()) {
                            int[] tmp = queue.poll();

                            for (int k = 0; k < M.length; k++) {
                                int a1 = tmp[0]++;
                                int a2 = tmp[1];
                                if (a1 >= 0 && a1 < M.length && a2 >= 0 && a2 < M[0].length && !visited[a1][a2] && M[a1][a2] == 1) {
                                    queue.add(new int[]{a1, a2});
                                    visited[a1][a2] = true;
                                    visited[a2][a1] = true;
                                    visited[a1][a1] = true;
                                }
                            }
                        }
                        res++;
                    }
                }
            }
            return res;
        }

        int[][] map;
        int ans;
        int count;

        public int findFriendNum(int[][] M) {
            if (M.length == 0 || M[0].length == 0) {
                return 0;
            }
            ans = 0;
            count = 0;
            map = new int[M.length][M[0].length];
            for (int i = 0; i < M.length; i++) {
                for (int j = 0; j < M[i].length; j++) {
                    dfs(M, i, j);
                }
            }
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < M.length; i++) {
                for (int j = 0; j < M[i].length; j++) {
                    if (!list.contains(map[i][j])) {
                        list.add(map[i][j]);
                    }
                }
            }
            return list.size();
        }

        private void dfs(int[][] M, int x, int y) {
            if (map[x][y] != 0 && M[x][y] == 1) {
                map[x][y] = ++count;
            }
            map[y][x] = count;
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    if (map[i][j] == count) {
                        list.add(i);
                        list.add(j);
                    }
                }
            }
            for (int i = 0; i < list.size() - 1; i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    map[list.get(i)][list.get(j)] = count;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] M = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        System.out.println(new Solution().findFriendNum(M));
    }
}

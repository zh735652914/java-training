package LeetCode.ProgrammerInterview;
/*
面试题 08.02. 迷路的机器人
设想有个机器人坐在一个网格的左上角，网格 r 行 c 列。机器人只能向下或向右移动，
但不能走到一些被禁止的网格（有障碍物）。设计一种算法，寻找机器人从左上角移动到右下角的路径。



网格中的障碍物和空位置分别用 1 和 0 来表示。

返回一条可行的路径，路径由经过的网格的行号和列号组成。左上角为 0 行 0 列。如果没有可行的路径，返回空数组。

示例 1:

输入:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
输出: [[0,0],[0,1],[0,2],[1,2],[2,2]]
解释:
输入中标粗的位置即为输出表示的路径，即
0行0列（左上角） -> 0行1列 -> 0行2列 -> 1行2列 -> 2行2列（右下角）
说明：r 和 c 的值均不超过 100。

通过次数2,835提交次数8,370
 */

import java.util.ArrayList;
import java.util.List;

public class pathWithObstacles {
    static class Solution {
        public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
            boolean[][] visited = new boolean[obstacleGrid.length][obstacleGrid[0].length];
            List<List<Integer>> path = new ArrayList<>();
            dfs(obstacleGrid, visited, path, 0, 0);
            return path;
//            if (dfs(obstacleGrid, visited, path, 0, 0)) {
//                return path;
//            } else {
//                return new ArrayList<>();
//            }
        }

        private boolean dfs(int[][] obstacleGrid, boolean[][] visited, List<List<Integer>> path, int x, int y) {
            if (x >= obstacleGrid.length || y >= obstacleGrid[0].length || obstacleGrid[x][y] == 1 || visited[x][y]) {
                return false;
            }
            List<Integer> curr_path = new ArrayList<>();
            curr_path.add(x);
            curr_path.add(y);
            path.add(curr_path);
            visited[x][y] = true;
            if (x == obstacleGrid.length - 1 && y == obstacleGrid[0].length - 1) {
                return true;
            }
            if (dfs(obstacleGrid, visited, path, x, y + 1) || dfs(obstacleGrid, visited, path, x + 1, y)) {
                return true;
            }
            path.remove(path.size() - 1);
            return false;
        }
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = {
//                {0, 0, 0},
//                {0, 1, 0},
//                {0, 0, 0}
                {0, 0}
        };
//        int[][] obstacleGrid = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {0, 0, 0, 1, 0}, {0, 0, 0, 0, 0}};
        System.out.println(new Solution().pathWithObstacles(obstacleGrid));
    }
}

package LeetCode.ProgrammerInterview;
/*
面试题 16.19. 水域大小
你有一个用于表示一片土地的整数矩阵land，该矩阵中每个点的值代表对应地点的海拔高度。
若值为0则表示水域。由垂直、水平或对角连接的水域为池塘。池塘的大小是指相连接的水域的个数。
编写一个方法来计算矩阵中所有池塘的大小，返回值需要从小到大排序。

示例：

输入：
[
  [0,2,1,0],
  [0,1,0,1],
  [1,1,0,1],
  [0,1,0,1]
]
输出： [1,2,4]
提示：

0 < len(land) <= 1000
0 < len(land[i]) <= 1000
通过次数5,512提交次数9,163
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//虽然效率很low，还好是自己写出来了
public class pondSizes {
    static class Solution {
        boolean[][] visited;

        public int[] pondSizes(int[][] land) {
            if (land == null || land.length == 0) {
                return new int[]{};
            }
            visited = new boolean[land.length][land[0].length];
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < land.length; i++) {
                for (int j = 0; j < land[i].length; j++) {
                    int count = dfs(land, i, j, 0);
                    if (count != 0) {
                        list.add(count);
                    }
                }
            }
            int[] ans = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                ans[i] = list.get(i);
            }
            Arrays.sort(ans);
            return ans;
        }

        private int dfs(int[][] land, int x, int y, int count) {
            if (x >= land.length || y >= land[0].length || x < 0 || y < 0) {
                return count;
            }
            if (land[x][y] == 0 && !visited[x][y]) {
                count++;
                visited[x][y] = true;
                count = dfs(land, x + 1, y, count);
                count = dfs(land, x, y + 1, count);
                count = dfs(land, x - 1, y, count);
                count = dfs(land, x, y - 1, count);
                count = dfs(land, x + 1, y + 1, count);
                count = dfs(land, x - 1, y - 1, count);
                count = dfs(land, x + 1, y - 1, count);
                count = dfs(land, x - 1, y + 1, count);
            }
            return count;
        }
    }

    public static void main(String[] args) {
        int[][] land = {
                {0, 2, 1, 0},
                {0, 1, 0, 1},
                {1, 1, 0, 1},
                {0, 1, 0, 1}
        };
        int[] ans = new Solution().pondSizes(land);
        for (int x : ans) {
            System.out.print(x + ",");
        }
        System.out.println();
    }
}

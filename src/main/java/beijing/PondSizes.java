package beijing;
/*
https://leetcode.cn/problems/pond-sizes-lcci/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhouhao
 * @date 2023/6/22 10:36
 */
public class PondSizes {
    // 写过的题都不会了
    static class Solution {
        private final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};

        public int[] pondSizes(int[][] land) {
            List<Integer> counts = new ArrayList<>();
            for (int i = 0; i < land.length; i++) {
                for (int j = 0; j < land[i].length; j++) {
                    if (land[i][j] == 0) {
                        counts.add(dfs(land, i, j));
                    }
                }
            }
            int[] ans = new int[counts.size()];
            for (int i = 0; i < ans.length; i++) {
                ans[i] = counts.get(i);
            }
            Arrays.sort(ans);
            return ans;
        }

        private int dfs(int[][] land, int x, int y) {
            if (x < 0 || y < 0 || x >= land.length || y >= land[0].length || land[x][y] != 0) {
                return 0;
            }
            land[x][y] = -1;
            int count = 1;
            for (int[] dir : dirs) {
                count += dfs(land, x + dir[0], y + dir[1]);
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
        System.out.println(Arrays.toString(new Solution().pondSizes(land)));
    }
}

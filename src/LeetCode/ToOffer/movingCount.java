package LeetCode.ToOffer;
/*
面试题13. 机器人的运动范围
地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？



示例 1：

输入：m = 2, n = 3, k = 1
输出：3
示例 1：

输入：m = 3, n = 1, k = 0
输出：1
提示：

1 <= n,m <= 100
0 <= k <= 20
通过次数2,644提交次数5,462
 */

import java.util.Scanner;

//一开始没看清题目的要求。。。
public class movingCount {
    static class Solution {
        public int movingCount(int m, int n, int k) {
            boolean[][] visited = new boolean[m][n];
            return dfs(0, 0, m, n, k, visited);
        }

        private int dfs(int x, int y, int m, int n, int k, boolean[][] visited) {
            if (x < 0 || y < 0 || x >= m || y >= n || (x / 10 + x % 10 + y / 10 + y % 10) > k || visited[x][y]) {
                return 0;
            }
            visited[x][y] = true;
            return dfs(x + 1, y, m, n, k, visited) + dfs(x - 1, y, m, n, k, visited) +
                    dfs(x, y + 1, m, n, k, visited) + dfs(x, y - 1, m, n, k, visited) + 1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        System.out.println(new Solution().movingCount(m, n, k));
    }
}

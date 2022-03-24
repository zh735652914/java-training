package Beijing;
/*
https://leetcode-cn.com/problems/image-smoother/
 */

public class imageSmoother {
    static class Solution {
        public int[][] imageSmoother(int[][] img) {
            int[][] ans = new int[img.length][img[0].length];
            for (int i = 0; i < ans.length; i++) {
                for (int j = 0; j < ans[i].length; j++) {
                    ans[i][j] = cal(img, i, j);
                }
            }
            return ans;
        }

        private int cal(int[][] img, int x, int y) {
            int sum = img[x][y];
            int count = 1;
            int[][] dirs = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
            for (int[] dir : dirs) {
                int Nx = x + dir[0];
                int Ny = y + dir[1];
                if (Nx < 0 || Nx >= img.length || Ny < 0 || Ny >= img[0].length) {
                    continue;
                }
                sum += img[Nx][Ny];
                count++;
            }
            return sum / count;
        }
    }

    public static void main(String[] args) {
        int[][] img = {
                {100, 200, 100},
                {200, 50, 200},
                {100, 200, 100}
        };
        int[][] ans = new Solution().imageSmoother(img);
        for (int[] an : ans) {
            for (int x : an) {
                System.out.print(x + ", ");
            }
            System.out.println();
        }
    }
}

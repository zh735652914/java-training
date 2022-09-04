package Beijing;
/*
https://leetcode.cn/problems/special-positions-in-a-binary-matrix/
 */

// 官方解答，真难懂，操，搞心态
public class numSpecial {
    static class Solution {
        public int numSpecial(int[][] mat) {
            int count = 0;
            for (int x = 0; x < mat.length; x++) {
                int cnt = 0;
                for (int y = 0; y < mat[x].length; y++) {
                    if (mat[x][y] == 1) {
                        cnt++;
                    }
                }
                if (x == 0) {
                    cnt--;
                }
                // 该列所有 1 所在行中的 1 的数量之和
                if (cnt > 0) {
                    for (int i = 0; i < mat[0].length; i++) {
                        if (mat[x][i] == 1) {
                            mat[0][i] += cnt;
                        }
                    }
                }
            }
            for (int num : mat[0]) {
                if (num == 1) {
                    count++;
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        int[][] mat = {
                {1, 0, 0},
                {0, 0, 1},
                {1, 0, 0}
        };
        System.out.println(new Solution().numSpecial(mat));
    }
}

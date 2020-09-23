package nowcoder;
/*
时间限制：C/C++ 3秒，其他语言6秒 空间限制：C/C++ 32M，其他语言64M 热度指数：19964
本题知识点： 数组
 算法知识视频讲解
题目描述
有一个NxN整数矩阵，请编写一个算法，将矩阵顺时针旋转90度。

给定一个NxN的矩阵，和矩阵的阶数N,请返回旋转后的NxN矩阵,保证N小于等于300。

测试样例：
[[1,2,3],[4,5,6],[7,8,9]],3
返回：[[7,4,1],[8,5,2],[9,6,3]]
 */

public class rotateMatrix {
    static public class Rotate {
        public int[][] rotateMatrix(int[][] mat, int n) {
            int[][] ans = new int[mat.length][mat[0].length];
            for (int i = 0; i < ans.length; i++) {
                for (int j = 0; j < ans[i].length; j++) {
                    ans[i][j] = mat[ans.length - j - 1][i];
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[][] mat = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int n = 3;
        int[][] ans = new Rotate().rotateMatrix(mat, n);
        for (int[] an : ans) {
            for (int i : an) {
                System.out.print(i + ",");
            }
            System.out.println();
        }
    }
}

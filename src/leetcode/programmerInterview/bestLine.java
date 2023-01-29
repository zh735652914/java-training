package leetcode.programmerInterview;
/*
面试题 16.14. 最佳直线
给定一个二维平面及平面上的 N 个点列表Points，其中第i个点的坐标为Points[i]=[Xi,Yi]。请找出一条直线，其通过的点的数目最多。

设穿过最多点的直线所穿过的全部点编号从小到大排序的列表为S，你仅需返回[S[0],S[1]]作为答案，若有多条直线穿过了相同数量的点，
则选择S[0]值较小的直线返回，S[0]相同则选择S[1]值较小的直线返回。

示例：

输入： [[0,0],[1,1],[1,0],[2,0]]
输出： [0,2]
解释： 所求直线穿过的3个点的编号为[0,2,3]
提示：

2 <= len(Points) <= 300
len(Points[i]) = 2
通过次数980提交次数1,979

 */

//自己还是不会写。。
public class bestLine {
    static class Solution {
        public int[] bestLine(int[][] points) {
            int[] ans = new int[2];
            int max = 0;
            for (int i = 0; i < points.length - 1; i++) {
                for (int j = i + 1; j < points.length; j++) {
                    int count = 0;
                    for (int k = 0; k < points.length; k++) {
                        if (check(points, i, j, k)) {
                            count++;
                        }
                        if (count > max) {
                            ans[0] = i;
                            ans[1] = j;
                            max = count;
                        } else if (count == max && i == ans[0] && j < ans[1]) {
                            ans[1] = j;
                        }
                    }
                }
            }
            return ans;
        }

        private boolean check(int[][] points, int a, int b, int c) {
            int x1 = points[a][0], y1 = points[a][1], x2 = points[b][0], y2 = points[b][1];
            return (y1 - y2) * points[c][0] + (x2 - x1) * points[c][1] + (x1 - x2) * y1 - (y1 - y2) * x1 == 0;
        }
    }

    public static void main(String[] args) {
        int[][] points = {{0, 0}, {1, 1}, {1, 0}, {2, 0}};
        int[] ans = new Solution().bestLine(points);
        for (int x : ans) {
            System.out.print(x + ",");
        }
        System.out.println();
    }
}

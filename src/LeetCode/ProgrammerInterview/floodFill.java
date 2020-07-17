package LeetCode.ProgrammerInterview;
/*
面试题 08.10. 颜色填充
编写函数，实现许多图片编辑软件都支持的「颜色填充」功能。

待填充的图像用二维数组 image 表示，元素为初始颜色值。初始坐标点的横坐标为 sr 纵坐标为 sc。需要填充的新颜色为 newColor 。

「周围区域」是指颜色相同且在上、下、左、右四个方向上存在相连情况的若干元素。

请用新颜色填充初始坐标点的周围区域，并返回填充后的图像。



示例：

输入：
image = [[1,1,1],[1,1,0],[1,0,1]]
sr = 1, sc = 1, newColor = 2
输出：[[2,2,2],[2,2,0],[2,0,1]]
解释:
初始坐标点位于图像的正中间，坐标 (sr,sc)=(1,1) 。
初始坐标点周围区域上所有符合条件的像素点的颜色都被更改成 2 。
注意，右下角的像素没有更改为 2 ，因为它不属于初始坐标点的周围区域。


提示：

image 和 image[0] 的长度均在范围 [1, 50] 内。
初始坐标点 (sr,sc) 满足 0 <= sr < image.length 和 0 <= sc < image[0].length 。
image[i][j] 和 newColor 表示的颜色值在范围 [0, 65535] 内。
通过次数4,135提交次数7,580
 */

//这题，我自己傻逼了。。。
public class floodFill {
    static class Solution {
        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            backtrack(image, sr, sc, newColor, image[sr][sc]);
            return image;
        }

        private void backtrack(int[][] image, int x, int y, int newColor, int last) {
            if (x < 0 || x >= image.length || y < 0 || y >= image[0].length) {
                return;
            }
            int tmp = image[x][y];
            if (tmp == last && tmp != newColor) {
                image[x][y] = newColor;
                backtrack(image, x + 1, y, newColor, tmp);
                backtrack(image, x - 1, y, newColor, tmp);
                backtrack(image, x, y + 1, newColor, tmp);
                backtrack(image, x, y - 1, newColor, tmp);
            }
        }
    }

    public static void main(String[] args) {
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr = 1, sc = 1, newColor = 2;
        int[][] ans = new Solution().floodFill(image, sr, sc, newColor);
//        for (int i = 0; i < ans.length; i++) {
//            for (int j = 0; j < ans[i].length; j++) {
//                System.out.println(ans[i][j] + ',');
//            }
//            System.out.println();
//        }
        for (int[] an : ans) {
            for (int i : an) {
                System.out.print(i + ",");
            }
            System.out.println();
        }
    }
}

package LeetCode.ProgrammerInterview;
/*
面试题 17.21. 直方图的水量
给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。



上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的直方图，在这种情况下，可以接 6 个单位的水（蓝色部分表示水）。 感谢 Marcos 贡献此图。

示例:

输入: [0,1,0,2,1,0,1,3,2,1,2,1]
输出: 6
通过次数3,951提交次数6,201
 */

public class trap {
    static class Solution {
        public int trap(int[] height) {
            int left = 0, right = height.length - 1;
            int tmp = 0;
            int ans = 0;
            while (left < right) {
                if (height[left] <= height[right]) {
                    tmp = Math.max(height[left], tmp);
                    ans += tmp - height[left++];
                } else {
                    tmp = Math.max(tmp, height[right]);
                    ans += tmp - height[right--];
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new Solution().trap(height));
    }
}

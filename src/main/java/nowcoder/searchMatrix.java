package nowcoder;
/*
 牛客题霸-名企高频面试题
矩阵查找 相似的企业真题
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：11475
本题知识点： 数组 二分
 算法知识视频讲解
题目描述
请写出一个高效的在m*n矩阵中判断目标值是否存在的算法，矩阵具有如下特征：
每一行的数字都从左到右排序
每一行的第一个数字都比上一行最后一个数字大
例如：
对于下面的矩阵：
[
    [1,   3,  5,  9],
    [10, 11, 12, 30],
    [230, 300, 350, 500]
]
要搜索的目标值为3，返回true；
示例1
输入
复制
[[1,1]],0
输出
复制
false
 */

public class searchMatrix {
    static public class Solution {
        /**
         * @param matrix int整型二维数组
         * @param target int整型
         * @return bool布尔型
         */
        public boolean searchMatrix(int[][] matrix, int target) {
            int x = 0, y = matrix[0].length - 1;
            while (x < matrix.length && y >= 0) {
                if (matrix[x][y] == target) {
                    return true;
                }
                if (matrix[x][y] > target) {
                    y--;
                } else {
                    x++;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 9},
                {10, 11, 12, 30},
                {230, 300, 350, 500}
        };
        int target = 3;
        System.out.println(new Solution().searchMatrix(matrix, target));
    }
}

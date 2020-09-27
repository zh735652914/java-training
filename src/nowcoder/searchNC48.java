package nowcoder;
/*
 牛客题霸-名企高频面试题
在转动过的有序数组中寻找目标值 相似的企业真题
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：11854
本题知识点： 数组 二分
 算法知识视频讲解
题目描述
给出一个转动过的有序数组，你事先不知道该数组转动了多少
(例如,0 1 2 4 5 6 7可能变为4 5 6 7 0 1 2).
在数组中搜索给出的目标值，如果能在数组中找到，返回它的索引，否则返回-1。
假设数组中不存在重复项。
示例1
输入
复制
[1],0
输出
复制
-1
题解 讨论 通过的代码笔记 纠错 收藏
 */

public class searchNC48 {
    static public class Solution {
        /**
         * @param A      int整型一维数组
         * @param target int整型
         * @return int整型
         */
        public int search(int[] A, int target) {
            int left = 0, right = A.length - 1;
            int pos = -1, mid = -1;
            while (left <= right) {
                mid = (left + right) / 2;
                if (A[mid] == target) {
                    return mid;
                }
                if (A[left] <= A[mid]) {
                    if (target < A[mid] && A[left] <= target) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                } else {
                    if (target > A[mid] && A[right] >= target) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }
            return pos;
        }
    }

    public static void main(String[] args) {
//        int[] nums = {4, 5, 6, 7, 0, 1, 2, 3};
//        int[] nums = {228, 234, 235, 236, 238, 239, 240, 241, 242, 243, 245, 248, 250, 253, 256, 257, 258, 260, 261, 262, 263, 264, 266, 268, 271, 272, 275, 276, 279, 280, 281, 282, 283, 284, 285, 287, 289, 291, 294, 295, 1, 6, 7, 8, 9, 10, 11, 13, 14, 15, 17, 18, 19, 20, 21, 22, 23, 25, 28, 30, 31, 36, 41, 43, 46, 48, 51, 52, 53, 54, 58, 59, 60, 62, 64, 66, 68, 72, 73, 77, 85, 86, 89, 92, 94, 95, 97, 98, 101, 105, 108, 112, 116, 118, 120, 121, 122, 124, 125, 127, 128, 129, 130, 131, 132, 135, 137, 139, 140, 142, 145, 147, 149, 152, 154, 156, 157, 158, 159, 168, 169, 170, 171, 172, 176, 178, 182, 185, 188, 190, 195, 200, 201, 202, 203, 204, 206, 208, 210, 212, 216, 219, 224, 226};
        int[] nums = {3, 1};
        int target = 1;
        System.out.println(new Solution().search(nums, target));
    }
}

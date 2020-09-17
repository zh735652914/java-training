package nowcoder;
/*
题目描述
请实现有重复数字的有序数组的二分查找。
输出在数组中第一个大于等于查找值的位置，如果数组中不存在这样的数，则输出数组长度加一。
示例1
输入
复制
5,4,[1,2,4,4,5]
输出
复制
3
 */

public class upper_bound_ {
    public static class Solution {
        /**
         * 二分查找
         *
         * @param n int整型 数组长度
         * @param v int整型 查找值
         * @param a int整型一维数组 有序数组
         * @return int整型
         */
        public int upper_bound_(int n, int v, int[] a) {
            int start = 0, end = n - 1;
            int mid = -1;
            if (a[n - 1] < v) {
                return n + 1;
            }
            while (start <= end) {
                mid = (start + end) / 2;
                if (a[mid] == v) {
                    if ((mid - 1) < 0 || a[mid - 1] < v) {
                        return mid + 1;
                    } else {
                        end = mid - 1;
                    }
                } else if (a[mid] > v) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            return start + 1;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 4, 5};
        int n = 5;
        int v = 4;
        System.out.println(new Solution().upper_bound_(n, v, nums));
    }
}

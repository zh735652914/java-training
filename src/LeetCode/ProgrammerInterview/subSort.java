package LeetCode.ProgrammerInterview;
/*
面试题 16.16. 部分排序
给定一个整数数组，编写一个函数，找出索引m和n，只要将索引区间[m,n]的元素排好序，整个数组就是有序的。注意：n-m尽量最小，
也就是说，找出符合条件的最短序列。函数返回值为[m,n]，若不存在这样的m和n（例如整个数组是有序的），请返回[-1,-1]。

示例：

输入： [1,2,4,7,10,11,7,12,6,7,16,18,19]
输出： [3,9]
提示：

0 <= len(array) <= 1000000
通过次数4,611提交次数10,632
 */

//自己弄了好久都没写出来，还是自己太菜了
public class subSort {
    static class Solution {
        public int[] subSort(int[] array) {
            if (array == null || array.length == 0) {
                return new int[]{-1, -1};
            }
            int left = -1, right = -1;
            int lmax = array[0], rmin = array[array.length - 1];
            for (int i = 0; i < array.length; i++) {
                if (lmax > array[i]) {
                    left = i;
                } else {
                    lmax = array[i];
                }
                if (rmin < array[array.length - i - 1]) {
                    right = array.length - i - 1;
                } else {
                    rmin = array[array.length - i - 1];
                }
            }
            return new int[]{right, left};
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
        int[] ans = new Solution().subSort(array);
        for (int x : ans) {
            System.out.println(x + ",");
        }
        System.out.println();
    }
}

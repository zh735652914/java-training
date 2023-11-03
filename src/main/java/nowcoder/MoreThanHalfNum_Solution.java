package nowcoder;
/*
 牛客题霸-名企高频面试题
数组中出现次数超过一半的数字 相似的企业真题
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：609283
本题知识点： 位运算 分治
 算法知识视频讲解
题目描述
数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
题解 讨论 通过的代码笔记 纠错 收藏
 */

import java.util.Arrays;

public class MoreThanHalfNum_Solution {
    static public class Solution0 {
        public int MoreThanHalfNum_Solution(int[] array) {
            Arrays.sort(array);
            int count = 0;
            int p = 0;
            for (int i = 0; i < array.length; i++) {
                p = array[i];
                count = 1;
                while (i + 1 < array.length && array[i + 1] == p) {
                    count++;
                    i++;
                }
                if (count * 2 > array.length) {
                    return p;
                }
            }
            return 0;
        }
    }

    static public class Solution {
        public int MoreThanHalfNum_Solution(int[] array) {
            int left = 0, right = array.length - 1;
            int count = 0;
            int pos = -1;
            while (left <= right) {
                if (array[left] == array[right]) {
                    if (count <= 0) {
                        pos = array[left];
                        count = 0;
                    }
                    count++;
                } else {
                    count--;
                }
                left++;
                right--;
            }
            if (count == 0) {
                return 0;
            }
            count = 0;
            for (int i = 0; i < array.length; i++) {
                if (pos == array[i]) {
                    count++;
                }
                if (2 * count > array.length) {
                    return pos;
                }
            }
            return 0;
        }
    }

    public static void main(String[] args) {
//        int[] array = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int[] array = {1, 2, 2, 3, 2};
        System.out.println(new Solution().MoreThanHalfNum_Solution(array));
    }
}

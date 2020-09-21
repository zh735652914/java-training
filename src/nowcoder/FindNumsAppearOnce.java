package nowcoder;
/*
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：421981
本题知识点： 位运算 哈希
 算法知识视频讲解
题目描述
一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */


import java.util.HashSet;
import java.util.Set;

public class FindNumsAppearOnce {
    static public class Solution {
        // num1,num2分别为长度为1的数组。传出参数
        // 将num1[0],num2[0]设置为返回结果
        public void FindNumsAppearOnce(int[] array, int[] num1, int[] num2) {
            Set<Integer> set = new HashSet<>(2);
            for (int x : array) {
                if (set.contains(x)) {
                    set.remove(x);
                } else {
                    set.add(x);
                }
            }
            int count = 1;
            for (int x : array) {
                if (set.contains(x)) {
                    if (count == 1) {
                        num1[0] = x;
                        count = 2;
                    } else {
                        num2[0] = x;
                    }
                }
            }

            System.out.println(num1[0] + "," + num2[0]);
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 1, 2, 3, 3, 4, 5, 5};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        new Solution().FindNumsAppearOnce(array, num1, num2);
    }
}

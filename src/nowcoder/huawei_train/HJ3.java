package nowcoder.huawei_train;
/*
 华为机试
明明的随机数 相似的企业真题
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：906714
本题知识点： 数组
 算法知识视频讲解
校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
题目描述
明明想在学校中请一些同学一起做一项问卷调查，为了实验的客观性，他先用计算机生成了N个1到1000之间的随机整数（N≤1000），对于其中重复的数字，
只保留一个，把其余相同的数去掉，不同的数对应着不同的学生的学号。然后再把这些数从小到大排序，按照排好的顺序去找同学做调查。
请你协助明明完成“去重”与“排序”的工作(同一个测试用例里可能会有多组数据，希望大家能正确处理)。



Input Param

n               输入随机数的个数

inputArray      n个随机整数组成的数组


Return Value

OutputArray    输出处理后的随机整数



注：测试用例保证输入参数的正确性，答题者无需验证。测试用例不止一组。

当没有新的输入时，说明输入结束。

输入描述:
输入多行，先输入随机整数的个数，再输入相应个数的整数

输出描述:
返回多行，处理后的结果

示例1
输入
复制
3
2
2
1
11
10
20
40
32
67
40
20
89
300
400
15
输出
复制
1
2
10
15
20
32
40
67
89
300
400
说明
样例输入解释：
样例有两组测试
第一组是3个数字，分别是：2，2，1。
第二组是11个数字，分别是：10，20，40，32，67，40，20，89，300，400，15。
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HJ3 {
    static public void solution0(int n, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        Integer[] ans = new Integer[set.size()];
        set.toArray(ans);
        Arrays.sort(ans);
        for (Integer x : ans) {
            System.out.println(x);
        }
    }

    static public void solution(int n, int[] nums) {
        boolean[] flag = new boolean[1001];
        for (int num : nums) {
            flag[num] = true;
        }
        for (int i = 0; i < flag.length; i++) {
            if (flag[i]) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }
            solution(n, nums);
        }
    }
}

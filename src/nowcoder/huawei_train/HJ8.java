package nowcoder.huawei_train;
/*
 华为机试
合并表记录 相似的企业真题
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：296946
本题知识点： 栈
 算法知识视频讲解
校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
题目描述
数据表记录包含表索引和数值（int范围的整数），请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照key值升序进行输出。

输入描述:
先输入键值对的个数
然后输入成对的index和value值，以空格隔开

输出描述:
输出合并后的键值对（多行）

示例1
输入
复制
4
0 1
0 2
1 2
3 4
输出
复制
0 3
1 2
3 4
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HJ8 {
    public void solution(int[][] nums) {
        Map<Integer, Integer> hashmap = new HashMap<>();
        for (int[] num : nums) {
            hashmap.put(num[0], hashmap.getOrDefault(num[0], 0) + num[1]);
        }
        Integer[] keys = new Integer[hashmap.size()];
        hashmap.keySet().toArray(keys);
        Arrays.sort(keys);
        for (Integer key : keys) {
            System.out.println(key + " " + hashmap.get(key));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[][] nums = new int[n][2];
            for (int i = 0; i < n; i++) {
                nums[i][0] = scanner.nextInt();
                nums[i][1] = scanner.nextInt();
            }
            new HJ8().solution(nums);
        }
    }
}

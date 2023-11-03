package nowcoder;
/*
 牛客题霸-名企高频面试题
随时找到数据流的中位数
时间限制：C/C++ 2秒，其他语言4秒 空间限制：C/C++ 256M，其他语言512M 热度指数：207
 算法知识视频讲解
题目描述
有一个源源不断的吐出整数的数据流，假设你有足够的空间来保存吐出的数。请设计一个名叫MedianHolder的结构，MedianHolder可以随时取得之前吐出所有数的中位数。
[要求]
1. 如果MedianHolder已经保存了吐出的N个数，那么将一个新数加入到MedianHolder的过程，其时间复杂度是O(logN)。
2. 取得已经吐出的N个数整体的中位数的过程，时间复杂度为O(1)

每行有一个整数opt表示操作类型
若opt=1，则接下来有一个整数N表示将N加入到结构中。
若opt=2，则表示询问当前所有数的中位数

示例1
输入
复制
[[1,5],[2],[1,3],[2],[1,6],[2],[1,7],[2]]
输出
复制
[5,4,5,5.5]
说明
第一次查询时结构内的数为：5
第二次查询时结构内的数为：3 5
第二次查询时结构内的数为：3 5 6
第二次查询时结构内的数为：3 5 6 7
示例2
输入
复制
[[2],[1,1],[2]]
输出
复制
[-1,1]
 */

import java.util.ArrayList;
import java.util.List;

public class flowmedian {
    static public class Solution {
        /**
         * the medians
         *
         * @param operations int整型二维数组 ops
         * @return double浮点型一维数组
         */
        List<Integer> list;

        public double[] flowmedian(int[][] operations) {
            List<Double> tmp = new ArrayList<>();
            list = new ArrayList<>();
            for (int[] Op : operations) {
                if (Op[0] == 1) {
                    insert(Op[1]);
                } else {
                    tmp.add(getMid());
                }
            }
            double[] ans = new double[tmp.size()];
            for (int i = 0; i < ans.length; i++) {
                ans[i] = tmp.get(i);
            }
            return ans;
        }

        private void insert(int x) {
            int left = 0, right = list.size() - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (list.get(mid) < x) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            list.add(left, x);
        }

        private double getMid() {
            if (list.size() % 2 == 1) {
                return list.get(list.size() / 2);
            } else {
                return ((double) list.get(list.size() / 2 - 1) + (double) list.get(list.size() / 2)) / 2;
            }
        }

    }

    public static void main(String[] args) {
        int[][] operations = {
                {1, 5},
                {2},
                {1, 3},
                {2},
                {1, 6},
                {2},
                {1, 7},
                {2}
        };
        double[] ans = new Solution().flowmedian(operations);
        for (double x : ans) {
            System.out.print(x + ",");
        }
    }
}

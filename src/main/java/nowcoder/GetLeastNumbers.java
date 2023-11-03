package nowcoder;
/*
 牛客题霸-名企高频面试题
最小的K个数 相似的企业真题
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：805330
本题知识点： 数组 高级算法
 算法知识视频讲解
题目描述
输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。

 */

import java.util.ArrayList;
import java.util.PriorityQueue;

public class GetLeastNumbers {
    static public class Solution {
        public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
            ArrayList<Integer> ans = new ArrayList<>(k);
            if (input == null || input.length < k || k == 0) {
                return ans;
            }
            PriorityQueue<Integer> queue = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);
            for (int i = 0; i < input.length; i++) {
                if (queue.size() != k) {
                    queue.offer(input[i]);
                } else if (queue.peek() > input[i]) {
//                    Integer tmp = queue.poll();
//                    tmp = null;
                    queue.poll();
                    queue.offer(input[i]);
                }
            }
            for (int i = 0; i < k; i++) {
                ans.add(queue.poll());
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 1, 6, 2, 7, 3, 8};
        int k = 4;
        System.out.println(new Solution().GetLeastNumbers_Solution(nums, k));
    }
}

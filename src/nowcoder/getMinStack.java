package nowcoder;
/*
时间限制：C/C++ 2秒，其他语言4秒 空间限制：C/C++ 256M，其他语言512M 热度指数：2014
本题知识点： 栈
 算法知识视频讲解
题目描述
实现一个特殊功能的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作。
示例1
输入
复制
[[1,3],[1,2],[1,1],[3],[2],[3]]
输出
复制
[1,2]
备注:
有三种操作种类，op1表示push，op2表示pop，op3表示getMin。你需要返回和op3出现次数一样多的数组，表示每次getMin的答案

1<=操作总数<=1000000
-1000000<=每个操作数<=1000000
数据保证没有不合法的操作
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class getMinStack {
    static public class Solution {
        /**
         * return a array which include all ans for op3
         *
         * @param op int整型二维数组 operator
         * @return int整型一维数组
         */
        Stack<Integer> stack;
        Stack<Integer> minStack;

        public int[] getMinStack(int[][] op) {
            stack = new Stack<>();
            minStack = new Stack<>();
            List<Integer> list = new ArrayList<>();
            for (int[] ints : op) {
                if (ints[0] == 1) {
                    stack.push(ints[1]);
                    if (minStack.isEmpty() || minStack.peek() >= ints[1]) {
                        minStack.push(ints[1]);
                    }
                } else if (ints[0] == 2) {
                    pop();
                } else if (ints[0] == 3) {
                    if (!minStack.isEmpty()) {
                        list.add(minStack.peek());
                    }
                }
            }
            int[] ans = new int[list.size()];
            for (int i = 0; i < ans.length; i++) {
                ans[i] = list.get(i);
            }
            return ans;
        }

        private void pop() {
            if (!minStack.isEmpty() && !stack.isEmpty() && stack.peek().equals(minStack.peek())) {
                stack.pop();
                minStack.pop();
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }

    }

    public static void main(String[] args) {
        int[][] op = {{1, 3}, {1, 2}, {1, 1}, {3, 0}, {2, 0}, {3, 0}};
        int[] ans = new Solution().getMinStack(op);
        for (int x : ans) {
            System.out.print(x + ",");
        }
        System.out.println();
    }
}

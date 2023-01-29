package leetcode.tooffer;
/*
面试题31. 栈的压入、弹出序列
输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。



示例 1：

输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
输出：true
解释：我们可以按以下顺序执行：
push(1), push(2), push(3), push(4), pop() -> 4,
push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
示例 2：

输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
输出：false
解释：1 不能在 2 之前弹出。


提示：

0 <= pushed.length == popped.length <= 1000
0 <= pushed[i], popped[i] < 1000
pushed 是 popped 的排列。
注意：本题与主站 946 题相同：https://leetcode-cn.com/problems/validate-stack-sequences/

通过次数2,546提交次数4,462
 */

import java.util.Scanner;
import java.util.Stack;

public class validateStackSequences {
    static class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            if (pushed == null || pushed.length == 0) return true;
            int p = 0, q = 0;
            Stack<Integer> stack = new Stack<>();
            while (p < pushed.length && q < popped.length) {
                if (pushed[p] != popped[q]) {
                    if (stack.isEmpty() || stack.peek() != popped[q]) {
                        stack.push(pushed[p]);
                    }
//                    while (!stack.isEmpty() && q < popped.length && stack.peek() == popped[q]) {
//                        stack.pop();
//                        q++;
//                    }
                    p++;
                } else {
                    p++;
                    q++;
                }
                while (!stack.isEmpty() && q < popped.length && stack.peek() == popped[q]) {
                    stack.pop();
                    q++;
                }
            }
            return stack.isEmpty();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        validateStackSequences validateStackSequences = new validateStackSequences();
        int[] pushed = {0, 1, 2};
        int[] popped = {1, 2, 0};
        System.out.println(new Solution().validateStackSequences(pushed, popped) + "~~~");
//        while (scanner.hasNext()) {
//            int[] pushed = validateStackSequences.retNum(scanner.nextLine().split(","));
//            int[] popped = validateStackSequences.retNum(scanner.nextLine().split(","));
//            System.out.println(new Solution().validateStackSequences(pushed, popped) + "~~~");
//        }
    }

    private int[] retNum(String[] Arr) {
        int[] nums = new int[Arr.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(Arr[i]);
        }
        return nums;
    }
}

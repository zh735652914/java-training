package Beijing;
/*
https://blog.csdn.net/weixin_34776645/article/details/113691654
 */

import java.util.Stack;

public class AmazonPrepare1 {
    static class Solution {

        // 别人写的
        public String solution1(int[] originalArray, int[] resultArray) {
            if (originalArray.length < 1 || resultArray.length < 1 || originalArray.length != resultArray.length) {
                return "None";
            }
            StringBuilder ans = new StringBuilder();
            Stack<Integer> stack = new Stack<>();
            stack.push(originalArray[0]);
            ans.append("push");
            ans.append(stack.peek());
            int indexOriginal = 1, indexResult = 0;
            while (!stack.isEmpty()) {
                if (indexResult < resultArray.length && stack.peek() == resultArray[indexResult]) {
                    ans.append("|pop");
                    ans.append(stack.pop());
                    indexResult++;
                    if (indexOriginal < originalArray.length) {
                        ans.append("|push");
                        ans.append(originalArray[indexOriginal]);
                        stack.push(originalArray[indexOriginal++]);
                    }
                } else {
                    if (indexOriginal < originalArray.length) {
                        ans.append("|push");
                        ans.append(originalArray[indexOriginal]);
                        stack.push(originalArray[indexOriginal++]);
                    } else {
                        break;
                    }
                }
            }
            if (!stack.isEmpty()) {
                return "None";
            }
            return ans.toString();
        }

        // 自己写的
        public String solution(int[] originalArray, int[] resultArray) {
            if (originalArray.length < 1 || resultArray.length < 1 || originalArray.length != resultArray.length) {
                return "None";
            }
            StringBuilder ans = new StringBuilder();
            Stack<Integer> stack = new Stack<>();
            stack.push(originalArray[0]);
            ans.append("push");
            ans.append(stack.peek());
            int indexOriginal = 1, indexResult = 0;
            while (indexResult < resultArray.length) {
                while (!stack.isEmpty() && indexResult < resultArray.length && stack.peek() == resultArray[indexResult]) {
                    indexResult++;
                    ans.append("|pop");
                    ans.append(stack.pop());
                }
                if (indexOriginal < originalArray.length) {
                    stack.push(originalArray[indexOriginal++]);
                    ans.append("|push");
                    ans.append(stack.peek());
                }
                if (!stack.isEmpty() && indexOriginal >= originalArray.length && stack.peek() != resultArray[indexResult]) {
                    break;
                }
            }
            if (!stack.isEmpty()) {
                return "None";
            }
            return ans.toString();
        }
    }

    public static void main(String[] args) {
        int[] originalArray = {1, 2, 3};
        int[] resultArray = {1, 2, 2};
        System.out.println(new Solution().solution(originalArray, resultArray));
    }
}

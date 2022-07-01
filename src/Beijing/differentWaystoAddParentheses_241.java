package Beijing;
/*
https://leetcode.cn/problems/different-ways-to-add-parentheses/
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 第二次了，自己还是不会写
public class differentWaystoAddParentheses_241 {
    static class Solution {
        private final Map<String, List<Integer>> cache = new HashMap<>();

        public List<Integer> diffWaysToCompute(String expression) {
            List<Integer> ans = new ArrayList<>();
            if (cache.containsKey(expression)) {
                return cache.get(expression);
            }
            int len = expression.length();
            for (int i = 0; i < len; i++) {
                char x = expression.charAt(i);
                if (!Character.isDigit(x)) {
                    List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                    List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
                    int sum = 0;
                    for (int L : left) {
                        for (int R : right) {
                            switch (x) {
                                case '+':
                                    sum = L + R;
                                    break;
                                case '-':
                                    sum = L - R;
                                    break;
                                case '*':
                                    sum = L * R;
                                    break;
                                case '/':
                                    sum = L / R;
                                    break;
                            }
                            ans.add(sum);
                        }
                    }
                }
            }
            if (ans.size() == 0) {
                ans.add(Integer.parseInt(expression));
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        String expression = "2-1-1";
        System.out.println(new Solution().diffWaysToCompute(expression));
    }
}

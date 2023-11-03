package beijing;
/*
https://leetcode-cn.com/problems/different-ways-to-add-parentheses/
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 这个很重要！自己不会写，得好好看看
public class diffWaysToCompute {
    static class Solution {
        Map<String, List<Integer>> cache = new HashMap<>();

        public List<Integer> diffWaysToCompute(String expression) {
            List<Integer> ans = new ArrayList<>();
            if (cache.containsKey(expression)) {
                return cache.get(expression);
            }
            int n = expression.length();
            for (int i = 0; i < n; i++) {
                if (!Character.isDigit(expression.charAt(i))) {
                    List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                    List<Integer> right = diffWaysToCompute(expression.substring(i + 1, n));
                    for (int L : left) {
                        for (int R : right) {
                            int x = 0;
                            switch (expression.charAt(i)) {
                                case '+':
                                    x = L + R;
                                    break;
                                case '-':
                                    x = L - R;
                                    break;
                                case '*':
                                    x = L * R;
                                    break;
                            }
                            ans.add(x);
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
        String expression = "2*3-4*5";
        System.out.println(new Solution().diffWaysToCompute(expression));
    }
}

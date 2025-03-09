package next;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouhao
 * @date 2025/3/9 16:27
 * https://leetcode.cn/problems/generate-parentheses/
 */
public class LeetCode22 {
    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        func(0, 0, n, new StringBuilder());
        return ans;
    }

    private void func(int left, int right, int n, StringBuilder stringBuilder) {
        if (left == right && left == n) {
            ans.add(stringBuilder.toString());
            return;
        }
        if (left < n) {
            stringBuilder.append('(');
            func(left + 1, right, n, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        if (left > right) {
            stringBuilder.append(')');
            func(left, right + 1, n, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }

    @Test
    public void test() {
        int n = 3;
        System.out.println(generateParenthesis(n));
    }
}

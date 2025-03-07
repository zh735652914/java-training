package next;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouhao
 * @date 2025/3/7 08:50
 * https://leetcode.cn/problems/letter-combinations-of-a-phone-number/
 */
public class LeetCode17 {

    String[] phone = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    List<String> ans = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() <= 0) {
            return new ArrayList<>();
        }
        List<String> strs = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            try {
                strs.add(phone[digits.charAt(i) - '0']);
            } catch (Exception e) {
                System.out.println("Input error");
            }
        }
        func(strs, 0, new StringBuilder());
        return ans;
    }

    private void func(List<String> strs, int index, StringBuilder stringBuilder) {
        if (index >= strs.size()) {
            ans.add(stringBuilder.toString());
            return;
        }
        String str = strs.get(index);
        int len = str.length();
        for (int i = 0; i < len; i++) {
            stringBuilder.append(str.charAt(i));
            func(strs, index + 1, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }

    @Test
    public void test() {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }
}

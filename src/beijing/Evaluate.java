package beijing;
/*
https://leetcode.cn/problems/evaluate-the-bracket-pairs-of-a-string/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhouhao
 * @date 2023/1/12 12:03
 */
// 这题是不难
public class Evaluate {
    static class Solution {
        public String evaluate(String s, List<List<String>> knowledge) {
            Map<String, String> map = new HashMap<>();
            for (List<String> know : knowledge) {
                map.put(know.get(0), know.get(1));
            }
            int len = s.length();
            int left = -1, right = -1;
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < len; i++) {
                if (s.charAt(i) == '(') {
                    left = i;
                    right = left;
                    while (right < len && s.charAt(right) != ')') {
                        right++;
                    }
                    String key = s.substring(left + 1, right);
                    if (map.containsKey(key)) {
                        ans.append(map.get(key));
                    } else {
                        ans.append('?');
                    }
                    i = right;
                } else {
                    ans.append(s.charAt(i));
                }
            }
            return ans.toString();
        }
    }

    public static void main(String[] args) {
        String s = "(name)is(age)yearsold";
        String[][] inputs = {{"name", "bob"}, {"age", "two"}};
        List<List<String>> knowledge = new ArrayList<>();
        for (String[] input : inputs) {
            List<String> row = new ArrayList<>();
            row.addAll(Arrays.asList(input));
            knowledge.add(row);
        }
        System.out.println(new Solution().evaluate(s, knowledge));
    }
}

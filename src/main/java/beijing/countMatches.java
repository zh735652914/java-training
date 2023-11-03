package beijing;
/*
https://leetcode.cn/problems/count-items-matching-a-rule/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class countMatches {
    // 的确很简单的题目
    static class Solution {
        public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
            int index = Objects.equals(ruleKey, "type") ? 0 : (Objects.equals(ruleKey, "color") ? 1 : 2);
            int count = 0;
            for (List<String> item : items) {
                if (Objects.equals(item.get(index), ruleValue)) {
                    count++;
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        String[][] input = {{"phone", "blue", "pixel"}, {"computer", "silver", "lenovo"}, {"phone", "gold", "iphone"}};
        List<List<String>> items = new ArrayList<>();
        for (String[] row : input) {
            List<String> item = Arrays.asList(row);
            items.add(item);
        }
        String ruleKey = "color", ruleValue = "silver";
        System.out.println(new Solution().countMatches(items, ruleKey, ruleValue));
    }
}

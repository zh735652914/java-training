package Beijing;
/*
https://leetcode.cn/problems/ambiguous-coordinates/
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// 自己没想到
public class ambiguousCoordinates {
    static class Solution {
        public List<String> ambiguousCoordinates(String s) {
            List<String> ans = new ArrayList();
            s = s.substring(1, s.length() - 1);
            int len = s.length();
            for (int i = 1; i < len; i++) {
                for (String x : getNum(s.substring(0, i))) {
                    for (String y : getNum(s.substring(i))) {
                        ans.add('(' + x + ", " + y + ')');
                    }
                }
            }
            return ans;
        }

        private List<String> getNum(String s) {
            int index = 1, len = s.length();
            List<String> nums = new ArrayList<>();
            while (index <= len) {
                String left = s.substring(0, index);
                String right = s.substring(index++);
                if ((!Objects.equals(left, "0") && left.charAt(0) == '0')
                        || !right.isEmpty() && right.charAt(right.length() - 1) == '0') {
                    continue;
                }
                if (right.isEmpty()) {
                    nums.add(left);
                } else {
                    nums.add(left + "." + right);
                }
            }
            return nums;
        }
    }

    public static void main(String[] args) {
        String s = "(123)";
        System.out.println(new Solution().ambiguousCoordinates(s));
    }
}

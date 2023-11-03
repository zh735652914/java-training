package beijing;
/*
https://leetcode.cn/problems/rearrange-spaces-between-words/
 */

import java.util.ArrayList;
import java.util.List;

// 自己写的不是很好
public class reorderSpaces {
    static class Solution {
        public String reorderSpaces(String text) {
            int count = 0;
            int len = text.length();
            for (int i = 0; i < len; i++) {
                if (text.charAt(i) == ' ') {
                    count++;
                }
            }
            String[] W = text.split(" ");
            List<String> words = new ArrayList<>();
            for (String x : W) {
                if (x.length() > 0) {
                    words.add(x);
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            int size = words.size();
            int sp = size < 2 ? 0 : count / (size - 1);
            StringBuilder space = new StringBuilder();
            space.append(" ".repeat(Math.max(0, sp)));
            int tailCount = count - sp * (size - 1);
            for (int i = 0; i < size - 1; i++) {
                stringBuilder.append(words.get(i));
                stringBuilder.append(space);
            }
            stringBuilder.append(words.get(size - 1));
            stringBuilder.append(" ".repeat(Math.max(0, tailCount)));
            return stringBuilder.toString();
        }
    }

    public static void main(String[] args) {
        String text = "";
        System.out.println(new Solution().reorderSpaces(text));
    }
}

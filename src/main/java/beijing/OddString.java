package beijing;
/*
https://leetcode.cn/problems/odd-string-difference/
 */

/**
 * @author zhouhao
 * @date 2023/5/25 12:52
 */
public class OddString {
    // 简单题错这么多次
    static class Solution {
        public String oddString(String[] words) {
            String A = getDiff(words[0]);
            String B = getDiff(words[1]);
            if (A.equals(B)) {
                for (int i = 2; i < words.length; i++) {
                    if (!A.equals(getDiff(words[i]))) {
                        return words[i];
                    }
                }
            }
            return B.equals(getDiff(words[2])) ? words[0] : words[1];
        }

        private String getDiff(String word) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < word.length() - 1; i++) {
                stringBuilder.append(word.charAt(i + 1) - word.charAt(i));
                stringBuilder.append(",");
            }
            return stringBuilder.toString();
        }
    }

    public static void main(String[] args) {
        String[] words = {"abm", "bcn", "alm"};
        System.out.println(new Solution().oddString(words));
    }
}

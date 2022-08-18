package Beijing;
/*
https://leetcode.cn/problems/longest-common-prefix/
 */

public class longestCommonPrefix_14_topInterviewList {
    // 第四次写了
    static class Solution {
        public String longestCommonPrefix(String[] strs) {
            int pos = 0;
            char x;
            while (true) {
                x = '@';
                for (String str : strs) {
                    if (pos >= str.length()) {
                        x = '#';
                        break;
                    }
                    if (x == '@') {
                        x = str.charAt(pos);
                    } else if (x != str.charAt(pos)) {
                        x = '#';
                        break;
                    }
                }
                if (x == '#') {
                    break;
                }
                pos++;
            }
            return strs[0].substring(0, pos);
        }
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(new Solution().longestCommonPrefix(strs));
    }
}

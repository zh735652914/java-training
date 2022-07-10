package Beijing;
/*
https://leetcode.cn/problems/longest-common-prefix/
 */

public class longestCommonPrefix_14 {
    // 感觉没必要写的很复杂
    static class Solution {
        public String longestCommonPrefix(String[] strs) {
            StringBuilder stringBuilder = new StringBuilder();
            int index = 0;
            while (true) {
                if (index >= strs[0].length()) {
                    break;
                }
                char ch = strs[0].charAt(index);
                boolean flag = true;
                for (int i = 1; i < strs.length; i++) {
                    if (index >= strs[i].length() || strs[i].charAt(index) != ch) {
                        flag = false;
                        break;
                    }
                }
                if (!flag) {
                    break;
                }
                stringBuilder.append(ch);
                index++;
            }
            return stringBuilder.toString();
        }
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(new Solution().longestCommonPrefix(strs));
    }
}

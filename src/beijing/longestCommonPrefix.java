package beijing;

/*
https://leetcode-cn.com/problems/longest-common-prefix/
 */
public class longestCommonPrefix {
    static class Solution {
        public String longestCommonPrefix(String[] strs) {
            StringBuilder stringBuilder = new StringBuilder();
            int index = 0;
            while (true) {
                if (index >= strs[0].length()) {
                    break;
                }
                boolean flag = false;
                char ch = strs[0].charAt(index);
                for (int i = 1; i < strs.length; i++) {
                    if (index >= strs[i].length()) {
                        flag = true;
                        break;
                    }
                    if (ch != strs[i].charAt(index)) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
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

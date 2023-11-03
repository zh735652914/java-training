package beijing;
/*
https://leetcode.cn/problems/check-if-binary-string-has-at-most-one-segment-of-ones/
 */

public class checkOnesSegment {
    static class Solution {
        // 好吧，不能想复杂了
        public boolean checkOnesSegment(String s) {
            int count = 0, len = s.length();
            for (int i = 0; i < len; i++) {
                if (s.charAt(i) == '1') {
                    count++;
                }
                while (i < len && s.charAt(i) == '1') {
                    i++;
                }
                if (count > 1) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        String s = "110";
        System.out.println(new Solution().checkOnesSegment(s));
    }
}

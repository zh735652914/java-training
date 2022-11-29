package Beijing;
/*
https://leetcode.cn/problems/minimum-changes-to-make-alternating-binary-string/
 */

/**
 * @author zhouhao
 * @date 2022/11/29 19:18
 */
public class MinOperations {
    // 自己没想到怎么写
    static class Solution {
        public int minOperations(String s) {
            int count = 0;
            int len = s.length();
            for (int i = 0; i < len; i++) {
                if (s.charAt(i) != '0' + (char) (i & 1)) {
                    count++;
                }
            }
            return Math.min(count, len - count);
        }
    }

    public static void main(String[] args) {
        String s = "10010100";
        System.out.println(new Solution().minOperations(s));
    }
}

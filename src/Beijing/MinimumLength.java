package Beijing;
/*
https://leetcode.cn/problems/minimum-length-of-string-after-deleting-similar-ends/
 */

/**
 * @author zhouhao
 * @date 2022/12/28 13:23
 */
public class MinimumLength {
    // 的确应该是easy难度
    static class Solution {
        public int minimumLength(String s) {
            int left = 0, right = s.length() - 1;
            while (left < right) {
                if (s.charAt(left) == s.charAt(right)) {
                    char x = s.charAt(left);
                    while (left <= right && s.charAt(left) == x) {
                        left++;
                    }
                    while (left <= right && s.charAt(right) == x) {
                        right--;
                    }
                } else {
                    break;
                }
            }
            return left > right ? 0 : right - left + 1;
        }
    }

    public static void main(String[] args) {
        String s = "bbbbbbbbbbbbbbbbbbbbbbbbbbbabbbbbbbbbbbbbbbccbcbcbccbbabbb";
        System.out.println(new Solution().minimumLength(s));
    }
}

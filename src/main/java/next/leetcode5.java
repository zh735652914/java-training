package next;

import org.junit.Test;

/**
 * @author zhouhao
 * @date 2025/1/4 12:42
 */
public class leetcode5 {
    @Test
    public void test() {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }

    int maxLeft = 0, maxRight = 0;

    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            getLen(s, i, i);
            getLen(s, i, i + 1);
        }
        return s.substring(maxLeft, maxRight + 1);
    }

    private void getLen(String s, int left, int right) {
        while (left <= right && left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            left--;
            right++;
        }
        if ((maxRight - maxLeft) < (right - left - 1)) {
            maxLeft = left + 1;
            maxRight = right - 1;
        }
    }
}

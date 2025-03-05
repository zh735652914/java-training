package next;

import org.junit.Test;

/**
 * @author zhouhao
 * @date 2025/3/5 08:24
 */
public class LeetCode1328 {
    public String breakPalindrome(String palindrome) {
        if (palindrome.length() <= 1) {
            return "";
        }
        char[] ch = palindrome.toCharArray();
        for (int i = 0; i * 2 + 1 < palindrome.length(); i++) {
            if (palindrome.charAt(i) != 'a') {
                ch[i] = 'a';
                return new String(ch);
            }
        }
        ch[ch.length - 1] = 'b';
        return new String(ch);
    }

    @Test
    public void test() {
        String palindrome = "abccba";
        System.out.println(breakPalindrome(palindrome));
    }
}

package Beijing;
/*
https://leetcode.cn/problems/palindrome-number/
 */

public class palindromeNumber_9 {
    // 还是看看题解吧，官方题解更巧妙
    static class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            }
            if (x < 10) {
                return true;
            }
            String s = String.valueOf(x);
            int left = 0, right = s.length() - 1;
            while (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        int x = 121;
        System.out.println(new Solution().isPalindrome(x));
    }
}

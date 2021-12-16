package Beijing;

import java.util.Scanner;

/*
https://leetcode-cn.com/problems/palindrome-number/
 */
public class isPalindrome {
    static class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            }
            if (x < 10) {
                return true;
            }
            String A = String.valueOf(x);
            int left = 0, right = A.length() - 1;
            while (left < right) {
                if (A.charAt(left) != A.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(new Solution().isPalindrome(scanner.nextInt()));
        }
    }
}

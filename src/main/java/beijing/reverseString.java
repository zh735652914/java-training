package beijing;
/*
https://leetcode.cn/problems/reverse-string/
 */

// 很简单
public class reverseString {
    static class Solution {
        public void reverseString(char[] s) {
            int left = 0, right = s.length - 1;
            while (left < right) {
                char tmp = s[left];
                s[left] = s[right];
                s[right] = tmp;
                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        new Solution().reverseString(s);
        for (char x : s) {
            System.out.print(x + ", ");
        }
    }
}

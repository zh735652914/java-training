package beijing;
/*
https://leetcode.cn/problems/reverse-string/
 */

// 很没意思的题目
public class reverseString_344 {
    static class Solution {
        public void reverseString(char[] s) {
            int left = 0, right = s.length - 1;
            char tmp;
            while (left < right) {
                tmp = s[left];
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

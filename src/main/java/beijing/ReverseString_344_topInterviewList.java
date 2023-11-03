package beijing;
/*
https://leetcode.cn/problems/reverse-string/
 */

/**
 * @author zhouhao
 * @date 2023/1/6 13:27
 */
// 的确是没有难度的题目
public class ReverseString_344_topInterviewList {
    static class Solution {
        public void reverseString(char[] s) {
            char tmp;
            int left = 0, right = s.length - 1;
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

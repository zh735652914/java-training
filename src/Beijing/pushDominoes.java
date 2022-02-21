package Beijing;
/*
https://leetcode-cn.com/problems/push-dominoes/
 */

import java.util.Arrays;

public class pushDominoes {
    // 自己不会写
    static class Solution {
        public String pushDominoes(String dominoes) {
            char[] s = dominoes.toCharArray();
            int index = 0;
            char left = 'L';
            while (index < s.length) {
                int end = index;
                while (end < s.length && s[end] == '.') {
                    end++;
                }
                char right = end < s.length ? s[end] : 'R';
                if (left == right) {
                    while (index < end) {
                        s[index++] = right;
                    }
                } else if (left == 'R' && right == 'L') {
                    int x = end - 1;
                    while (index < x) {
                        s[index++] = left;
                        s[x--] = right;
                    }
                }
                left = right;
                index = end + 1;
            }
//            return Arrays.toString(s);
            return new String(s);
        }
    }

    public static void main(String[] args) {
        String dominoes = ".L.R...LR..L..";
        System.out.println(new Solution().pushDominoes(dominoes));
    }
}

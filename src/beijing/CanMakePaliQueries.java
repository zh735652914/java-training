package beijing;
/*
https://leetcode.cn/problems/can-make-palindrome-from-substring/
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouhao
 * @date 2023/6/15 12:50
 */
public class CanMakePaliQueries {
    // 这题考的挺多的
    static class Solution {
        public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
            int[] count = new int[s.length() + 1];
            for (int i = 0; i < s.length(); i++) {
                count[i + 1] = count[i] ^ (1 << (s.charAt(i) - 'a'));
            }
            List<Boolean> ans = new ArrayList<>();
            for (int i = 0; i < queries.length; i++) {
                int left = queries[i][0], right = queries[i][1], k = queries[i][2];
                int x = count[right + 1] ^ count[left];
                int bits = 0;
                // 计算x二进制中1的个数
                while (x > 0) {
                    bits++;
                    x &= x - 1;
                }
                ans.add(bits <= (k * 2 + 1));
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        String s = "abcda";
        int[][] queries = {{3, 3, 0}, {1, 2, 0}, {0, 3, 1}, {0, 3, 2}, {0, 4, 1}};
        System.out.println(new Solution().canMakePaliQueries(s, queries));
    }
}

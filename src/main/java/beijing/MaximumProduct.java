package beijing;
/*
https://leetcode.cn/problems/maximum-product-of-word-lengths/
 */

/**
 * @author zhouhao
 * @date 2023/11/6 11:51
 */
public class MaximumProduct {
    static class Solution {
        public int maxProduct(String[] words) {
            int[] count = new int[words.length];
            for (int i = 0; i < words.length; i++) {
                int len = words[i].length();
                for (int j = 0; j < len; j++) {
                    count[i] |= 1 << (words[i].charAt(j) - 'a');
                }
            }
            int ans = 0;
            for (int i = 0; i < count.length - 1; i++) {
                for (int j = i + 1; j < count.length; j++) {
                    if ((count[i] & count[j]) == 0) {
                        ans = Math.max(ans, words[i].length() * words[j].length());
                    }
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        String[] words = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        System.out.println(new Solution().maxProduct(words));
    }
}

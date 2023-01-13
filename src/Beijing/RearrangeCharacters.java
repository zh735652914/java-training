package Beijing;
/*
https://leetcode.cn/problems/rearrange-characters-to-make-target-string/
 */

/**
 * @author zhouhao
 * @date 2023/1/13 13:20
 */
// 的确是简单题
public class RearrangeCharacters {
    static class Solution {
        public int rearrangeCharacters(String s, String target) {
            int[] map = new int[26];
            for (int i = 0; i < target.length(); i++) {
                map[target.charAt(i) - 'a']++;
            }
            int[] count = new int[26];
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i) - 'a']++;
            }
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < 26; i++) {
                if (map[i] > 0) {
                    ans = Math.min(ans, count[i] / map[i]);
                }
            }
            return ans == Integer.MAX_VALUE ? 0 : ans;
        }
    }

    public static void main(String[] args) {
        String s = "ilovecodingonleetcode", target = "code";
        System.out.println(new Solution().rearrangeCharacters(s, target));
    }
}

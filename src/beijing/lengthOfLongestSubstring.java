package beijing;

/*
https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class lengthOfLongestSubstring {
    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            int[] last = new int[128];
            for (int i = 0; i < 128; i++) {
                last[i] = -1;
            }
            int MaxLen = 0;
            int start = 0;
            for (int i = 0; i < s.length(); i++) {
                int index = s.charAt(i);
                start = Math.max(start, last[index] + 1);
                MaxLen = Math.max(MaxLen, i - start + 1);
                last[index] = i;
            }
            return MaxLen;
        }
    }

    public static void main(String[] args) {
        String s = "ckilbkd";
        System.out.println(new Solution().lengthOfLongestSubstring(s));
    }
}

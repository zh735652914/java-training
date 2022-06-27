package Beijing.hot100;
/*
https://leetcode.cn/problems/find-all-anagrams-in-a-string/
 */

import java.util.ArrayList;
import java.util.List;

// 第二次，自己还是没写出来
public class findAllAnagramsinaString_438 {
    static class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> ans = new ArrayList<>();
            if (p.length() > s.length()) {
                return ans;
            }
            int[] count = new int[26];
            int lenP = p.length();
            for (int i = 0; i < lenP; i++) {
                count[s.charAt(i) - 'a']++;
                count[p.charAt(i) - 'a']--;
            }
            int diff = 0;
            for (int num : count) {
                if (num != 0) {
                    diff++;
                }
            }
            if (diff == 0) {
                ans.add(0);
            }
            int lenS = s.length();
            for (int i = 0; i < lenS - lenP; i++) {
                int left = s.charAt(i) - 'a';
                if (count[left] == 1) {
                    diff--;
                } else if (count[left] == 0) {
                    diff++;
                }
                count[left]--;
                int right = s.charAt(i + lenP) - 'a';
                if (count[right] == -1) {
                    diff--;
                } else if (count[right] == 0) {
                    diff++;
                }
                count[right]++;
                if (diff == 0) {
                    ans.add(i + 1);
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        System.out.println(new Solution().findAnagrams(s, p));
    }
}

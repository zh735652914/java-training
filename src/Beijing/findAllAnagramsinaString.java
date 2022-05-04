package Beijing;
/*
https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 */

import java.util.ArrayList;
import java.util.List;

// 没写出来，感觉自己是个智障
public class findAllAnagramsinaString {
    static class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> ans = new ArrayList<>();
            int[] count = new int[26];
            if (p.length() > s.length()) {
                return ans;
            }
            int diff = 0;
            int m = s.length(), n = p.length();
            for (int i = 0; i < n; i++) {
                count[s.charAt(i) - 'a']--; // s字符串有就-1
                count[p.charAt(i) - 'a']++; // 源字符串有就+1
            }
            // count[i]==1 仅源字符串有；
            // count[i]==-1 仅s字符串有；
            // count[i]==0 两字符串相同，都有
            for (int num : count) {
                if (num != 0) {
                    diff++;
                }
            }
            if (diff == 0) {
                ans.add(0);
            }
            for (int i = 0; i < m - n; i++) {
                int left = s.charAt(i) - 'a';
                if (count[left] == -1) {
                    diff--;
                } else if (count[left] == 0) {
                    diff++;
                }
                count[left]++;
                int right = s.charAt(i + n) - 'a';
                if (count[right] == 1) {
                    diff--;
                } else if (count[right] == 0) {
                    diff++;
                }
                count[right]--;
                if (diff == 0) {
                    ans.add(i + 1);
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
//        String s = "af", p = "be";
        System.out.println(new Solution().findAnagrams(s, p));
    }
}

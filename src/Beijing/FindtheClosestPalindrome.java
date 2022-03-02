package Beijing;
/*
https://leetcode-cn.com/problems/find-the-closest-palindrome/
 */

import java.util.ArrayList;
import java.util.List;

public class FindtheClosestPalindrome {
    // 自己怎么这么菜？？？？
    static class Solution {
        public String nearestPalindromic(String n) {
            if (n.length() == 1) {
                return String.valueOf(Long.parseLong(n) - 1);
            }
            List<Long> candidates = getCandidates(n);
            long x = Long.parseLong(n), ans = -1;
            for (Long candidate : candidates) {
                if (candidate != x) {
                    if (ans == -1 || Math.abs(candidate - x) < Math.abs(ans - x) || Math.abs(candidate - x) == Math.abs(ans - x) && candidate < ans) {
                        ans = candidate;
                    }
                }
            }
            return String.valueOf(ans);
        }

        private List<Long> getCandidates(String n) {
            int len = n.length();
            List<Long> candidates = new ArrayList<>() {{
                add((long) (Math.pow(10, len) + 1));
                add((long) (Math.pow(10, len - 1) - 1));
            }};
            long preFix = Long.parseLong(n.substring(0, (len + 1) / 2));
            for (long i = preFix - 1; i <= preFix + 1; i++) {
                StringBuilder stringBuilder = new StringBuilder();
                String stPreFix = String.valueOf(i);
                stringBuilder.append(stPreFix);
                StringBuilder right = new StringBuilder(stPreFix).reverse();
                stringBuilder.append(right.substring(len & 1)); // 奇偶性
                String candidate = stringBuilder.toString();
                candidates.add(Long.valueOf(candidate));
            }
            return candidates;
        }
    }

    public static void main(String[] args) {
        String n = "88";
        System.out.println(new Solution().nearestPalindromic(n));
    }
}

package Beijing;
/*
https://leetcode-cn.com/problems/repeated-dna-sequences/
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class findRepeatedDnaSequences {
    // 这个滑动窗口，自己不会写
    static class Solution {
        public List<String> findRepeatedDnaSequences(String s) {
            Map<Character, Integer> bin = new HashMap<>() {{
                put('A', 0);
                put('C', 1);
                put('G', 2);
                put('T', 3);
            }};
            List<String> ans = new ArrayList<>();
            int n = s.length();
            if (n < 10) {
                return ans;
            }
            int x = 0;
            for (int i = 0; i < 9; i++) {
                x = (x << 2) | bin.get(s.charAt(i));
            }
            Map<Integer, Integer> cnt = new HashMap<>();
            for (int i = 0; i <= n - 10; i++) {
                x = ((x << 2) | bin.get(s.charAt(i + 9))) & ((1 << 20) - 1);
                cnt.put(x, cnt.getOrDefault(x, 0) + 1);
                if (cnt.get(x) == 2) {
                    ans.add(s.substring(i, i + 10));
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(new Solution().findRepeatedDnaSequences(s));
    }
}

package beijing;
/*
https://leetcode.cn/problems/swap-for-longest-repeated-character-substring/
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhouhao
 * @date 2023/6/3 17:57
 */
public class MaxRepOpt1 {
    // 滑动窗口，又是要看解析
    static class Solution {
        public int maxRepOpt1(String text) {
            Map<Character, Integer> count = new HashMap<>();
            int len = text.length();
            for (int i = 0; i < len; i++) {
                count.put(text.charAt(i), count.getOrDefault(text.charAt(i), 0) + 1);
            }
            int ans = 1;
            for (int i = 0; i < len; ) {
                int right = i;
                while (right < len && text.charAt(i) == text.charAt(right)) {
                    right++;
                }
                if (right - i == count.get(text.charAt(i))) {
                    ans = Math.max(ans, right - i);
                    i = right;
                    continue;
                }
                ans = Math.max(ans, right - i + 1);// 直接交换一个相同字符到子串后面
                int j = right + 1;
                while (j < len && text.charAt(j) == text.charAt(i)) {
                    j++;
                }
                ans = Math.max(ans, Math.min(j - i, count.get(text.charAt(i))));
                i = right;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        String text = "aaabaaa";
        System.out.println(new Solution().maxRepOpt1(text));
    }
}

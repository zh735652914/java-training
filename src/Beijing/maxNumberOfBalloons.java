package Beijing;
/*
https://leetcode-cn.com/problems/maximum-number-of-balloons/
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class maxNumberOfBalloons {
    // 官方的更加简洁
    static class Solution {
        public int maxNumberOfBalloons(String text) {
            int[] count = new int[5];
            for (int i = 0; i < text.length(); i++) {
                switch (text.charAt(i)) {
                    case 'a':
                        count[0]++;
                        continue;
                    case 'b':
                        count[1]++;
                        continue;
                    case 'l':
                        count[2]++;
                        continue;
                    case 'o':
                        count[3]++;
                        continue;
                    case 'n':
                        count[4]++;
                        continue;
                }
            }
            count[2] /= 2;
            count[3] /= 2;
            return Arrays.stream(count).min().getAsInt();
        }
    }

    static class Solution0 {
        public int maxNumberOfBalloons(String text) {
            Map<Character, Integer> instance = new HashMap<>();
            instance.put('a', 1);
            instance.put('b', 1);
            instance.put('l', 2);
            instance.put('o', 2);
            instance.put('n', 1);
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < text.length(); i++) {
                map.put(text.charAt(i), map.getOrDefault(text.charAt(i), 0) + 1);
            }
            int ans = Integer.MAX_VALUE;
            for (Map.Entry<Character, Integer> entry : instance.entrySet()) {
                ans = Math.min(ans, map.getOrDefault(entry.getKey(), 0) / entry.getValue());
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        String text = "balon";
        System.out.println(new Solution().maxNumberOfBalloons(text));
    }
}

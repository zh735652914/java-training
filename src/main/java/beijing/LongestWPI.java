package beijing;
/*
https://leetcode.cn/problems/longest-well-performing-interval/description/
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhouhao
 * @date 2023/2/14 12:58
 */
public class LongestWPI {
    // 很牛逼，但是自己不会写
    static class Solution {
        public int longestWPI(int[] hours) {
            Map<Integer, Integer> map = new HashMap<>();
            int sum = 0, ans = 0;
            for (int i = 0; i < hours.length; i++) {
                sum += hours[i] > 8 ? 1 : -1;
                if (sum > 0) {
                    ans = Math.max(ans, i + 1);
                } else {
                    if (map.containsKey(sum - 1)) { // 这个地方是精髓了
                        ans = Math.max(ans, i - map.get(sum - 1));
                    }
                }
                if (!map.containsKey(sum)) {
                    map.put(sum, i);
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] hours = {9, 9, 6, 0, 6, 6, 9};
        System.out.println(new Solution().longestWPI(hours));
    }
}

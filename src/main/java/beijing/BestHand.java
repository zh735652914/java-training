package beijing;
/*
https://leetcode.cn/problems/best-poker-hand/
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhouhao
 * @date 2023/2/20 12:32
 */
public class BestHand {
    // 的确是简单题
    static class Solution {
        public String bestHand(int[] ranks, char[] suits) {
            char x = suits[0];
            boolean flush = true;
            for (int i = 1; i < suits.length; i++) {
                if (x != suits[i]) {
                    flush = false;
                    break;
                }
            }
            if (flush) {
                return "Flush";
            }
            Map<Integer, Integer> map = new HashMap<>();
            for (int rank : ranks) {
                map.put(rank, map.getOrDefault(rank, 0) + 1);
                if (map.get(rank) == 3) {
                    return "Three of a Kind";
                }
            }
            for (int value : map.values()) {
                if (value == 2) {
                    return "Pair";
                }
            }
            return "High Card";
        }
    }

    public static void main(String[] args) {
        int[] ranks = {13, 2, 3, 1, 9};
        char[] suits = {'a', 'a', 'a', 'a', 'a'};
        System.out.println(new Solution().bestHand(ranks, suits));
    }
}

package beijing;
/*
https://leetcode.cn/problems/lemonade-change/
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhouhao
 * @date 2023/7/22 10:14
 */
public class LemonadeChange {
    // 能过，但是一般，可以优化
    static class Solution {
        public boolean lemonadeChange(int[] bills) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int bill : bills) {
                if (bill == 5) {
                    map.put(5, map.getOrDefault(5, 0) + 1);
                    continue;
                } else if (bill == 10) {
                    if (map.getOrDefault(5, 0) < 1) {
                        return false;
                    }
                    map.put(5, map.get(5) - 1);
                    map.put(10, map.getOrDefault(10, 0) + 1);
                } else if (bill == 20) {
                    if (map.getOrDefault(10, 0) >= 1 && map.getOrDefault(5, 0) >= 1) {
                        map.put(20, map.getOrDefault(20, 0) + 1);
                        map.put(10, map.get(10) - 1);
                        map.put(5, map.get(5) - 1);
                    } else if (map.getOrDefault(5, 0) >= 3) {
                        map.put(20, map.getOrDefault(20, 0) + 1);
                        map.put(5, map.get(5) - 3);
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        int[] bills = {5, 5, 10, 10, 20};
        System.out.println(new Solution().lemonadeChange(bills));
    }
}

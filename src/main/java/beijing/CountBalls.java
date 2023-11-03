package beijing;
/*
https://leetcode.cn/problems/maximum-number-of-balls-in-a-box/
 */

import java.util.HashMap;
import java.util.Map;

public class CountBalls {
    // 官方题解也是这样写的
    static class Solution {
        public int countBalls(int lowLimit, int highLimit) {
            Map<Integer, Integer> map = new HashMap<>();
            int ans = -1;
            for (int i = lowLimit; i <= highLimit; i++) {
                int num = boxNum(i);
                map.put(num, map.getOrDefault(num, 0) + 1);
                ans = Math.max(ans, map.get(num));
            }
            return ans;
        }

        private int boxNum(int x) {
            if (x < 10) {
                return x;
            }
            int num = 0;
            while (x > 0) {
                num += x % 10;
                x /= 10;
            }
            return num;
        }
    }

    public static void main(String[] args) {
        int lowLimit = 1, highLimit = 10;
        System.out.println(new Solution().countBalls(lowLimit, highLimit));
    }
}

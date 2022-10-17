package Beijing;
/*
https://leetcode.cn/problems/fruit-into-baskets/
 */

import java.util.HashMap;
import java.util.Map;

public class totalFruit {
    // 自己一开始没有思路
    static class Solution {
        public int totalFruit(int[] fruits) {
            Map<Integer, Integer> map = new HashMap<>();
            int ans = 0;
            int left = 0;
            for (int right = 0; right < fruits.length; right++) {
                if (!map.containsKey(fruits[right])) {
                    while (map.size() >= 2 && left < right) {
                        int count = map.getOrDefault(fruits[left], 0) - 1;
                        if (count <= 0) {
                            map.remove(fruits[left]);
                        } else {
                            map.put(fruits[left], count);
                        }
                        left++;
                    }
                    map.put(fruits[right], 1);
                } else {
                    map.put(fruits[right], map.get(fruits[right]) + 1);
                }
                ans = Math.max(ans, right - left + 1);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] fruits = {1, 2, 3, 2, 2};
        System.out.println(new Solution().totalFruit(fruits));
    }
}

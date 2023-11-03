package beijing;
/*
https://leetcode-cn.com/problems/array-of-doubled-pairs/
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 情况需要考虑清楚
public class canReorderDoubled {
    static class Solution {
        public boolean canReorderDoubled(int[] arr) {
            Map<Integer, Integer> map = new HashMap<>(arr.length);
            Arrays.sort(arr);
            int n = arr.length;
            for (int i = 0; i < n; i++) {
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            }
            int count = 0;
            for (int i = 0; i < n; i++) {
                int key1 = arr[i];
                int key2 = arr[i] >= 0 ? 2 * arr[i] : arr[i] / 2;
                if (map.get(key1) > 0 && map.containsKey(key2) && map.get(key2) > 0) {
                    if (key1 < 0 && key2 * 2 != key1) {
                        continue;
                    }
                    if (key1 == key2 && map.get(key1) < 2) {
                        continue;
                    }
                    count++;
                    map.put(key1, map.get(key1) - 1);
                    map.put(key2, map.get(key2) - 1);
                }
            }
            return count >= n / 2;
        }
    }

    public static void main(String[] args) {
//        int[] arr = {1, 2, 4, 16, 8, 4};
        int[] arr = {-33, 0};
        System.out.println(new Solution().canReorderDoubled(arr));
    }
}

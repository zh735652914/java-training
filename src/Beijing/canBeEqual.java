package Beijing;
/*
https://leetcode.cn/problems/make-two-arrays-equal-by-reversing-sub-arrays/
 */

import java.util.HashMap;
import java.util.Map;

public class canBeEqual {
    static class Solution {
        // 自己写的，效率不高，但是排序就没意思了
        public boolean canBeEqual(int[] target, int[] arr) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : target) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            for (int num : arr) {
                if (!map.containsKey(num)) {
                    return false;
                }
                if (map.get(num) == 1) {
                    map.remove(num);
                } else {
                    map.put(num, map.get(num) - 1);
                }
            }
            return map.size() == 0;
        }
    }

    public static void main(String[] args) {
        int[] target = {1, 2, 3, 4}, arr = {2, 4, 1, 3};
        System.out.println(new Solution().canBeEqual(target, arr));
    }
}

package beijing;
/*
https://leetcode-cn.com/problems/sum-of-unique-elements/
 */


import java.util.HashMap;
import java.util.Map;

public class sumOfUnique {
    static class Solution {
        public int sumOfUnique(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            int ans = 0;
//            for (int key : map.keySet()) {
//                if (map.get(key) == 1) {
//                    ans += key;
//                }
//            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 1) {
                    ans += entry.getKey();
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1};
        System.out.println(new Solution().sumOfUnique(nums));
    }
}

package beijing;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhouhao
 * @date 2023/10/19 19:57
 */
public class TupleSameProduct {
    static class Solution {
        // 自己没写出来，数学题
        public int tupleSameProduct(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    int key = nums[i] * nums[j];
                    map.put(key, map.getOrDefault(key, 0) + 1);
                }
            }
            int ans = 0;
            for (int count : map.values()) {
                ans += count * (count - 1) * 4;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 6};
        System.out.println(new Solution().tupleSameProduct(nums));
    }
}

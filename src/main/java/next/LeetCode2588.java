package next;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhouhao
 * @date 2025/3/6 08:29
 * http://leetcode.cn/problems/count-the-number-of-beautiful-subarrays/?envType=daily-question&envId=2025-03-06
 */
public class LeetCode2588 {
    public long beautifulSubarrays(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        int mask = 0;
        long ans = 0;
        cnt.put(0, 1);
        for (int x : nums) {
            mask ^= x;
            ans += cnt.getOrDefault(mask, 0);
            cnt.put(mask, cnt.getOrDefault(mask, 0) + 1);
        }
        return ans;
    }

    @Test
    public void test() {
        int[] nums = {4, 3, 1, 2, 4};
        System.out.println(beautifulSubarrays(nums));
    }
}

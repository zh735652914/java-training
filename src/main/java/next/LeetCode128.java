package next;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;

/**
 * @author zhouhao
 * @date 2025/3/26 08:34
 * https://leetcode.cn/problems/longest-consecutive-sequence/description/
 */
public class LeetCode128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int ans = 0;
        int count = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                count = 1;
                while (set.contains(num + 1)) {
                    count++;
                    num++;
                }
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }

    @Test
    public void test() {
        int[] nums = {100, 4, 200, 1, 3, 2};
        assertEquals(4, longestConsecutive(nums));
    }
}

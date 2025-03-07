package next;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhouhao
 * @date 2025/3/7 08:19
 * https://leetcode.cn/problems/the-number-of-beautiful-subsets/description/?envType=daily-question&envId=2025-03-07
 */
public class LeetCode2597 {
    int ans;
    Map<Integer, Integer> map;

    public int beautifulSubsets(int[] nums, int k) {
        map = new HashMap<>();
        ans = 0;
        dfs(nums, k, 0);
        return ans - 1;
    }

    private void dfs(int[] nums, int k, int index) {
        if (index == nums.length) {
            ans++;
            return;
        }
        dfs(nums, k, index + 1);
        if (map.getOrDefault(nums[index] - k, 0) == 0 && map.getOrDefault(nums[index] + k, 0) == 0) {
            map.put(nums[index], map.getOrDefault(nums[index], 0) + 1);
            dfs(nums, k, index + 1);
            map.put(nums[index], map.getOrDefault(nums[index], 0) - 1);
        }
    }

    @Test
    public void test() {
        int[] nums = {2, 4, 6};
        int k = 2;
        System.out.println(beautifulSubsets(nums, k));
    }
}

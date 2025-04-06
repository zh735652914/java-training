package next;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhouhao
 * @date 2025/4/6 09:51
 * https://leetcode.cn/problems/largest-divisible-subset/?envType=daily-question&envId=2025-04-06
 */
public class LeetCode368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int maxSize = 1;
        int maxVal = dp[0];
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] > maxSize) {
                maxSize = dp[i];
                maxVal = nums[i];
            }
        }

        List<Integer> ans = new ArrayList<>();
        if (maxSize == 1) {
            ans.add(nums[0]);
            return ans;
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (dp[i] == maxSize && maxVal % nums[i] == 0) {
                ans.add(nums[i]);
                maxVal = nums[i];
                maxSize--;
            }
        }
        return ans;
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 4, 8};
        List<Integer> ans = largestDivisibleSubset(nums);
        System.out.println(ans);
//        assertEquals("[1,2,4,8]", String.valueOf(ans));
    }
}

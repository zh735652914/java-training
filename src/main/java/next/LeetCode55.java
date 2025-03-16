package next;

import org.junit.Test;

/**
 * @author zhouhao
 * @date 2025/3/16 11:17
 * https://leetcode.cn/problems/jump-game/
 */
public class LeetCode55 {
    public boolean canJump(int[] nums) {
        int nextFar = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= nextFar) {
                nextFar = Math.max(nextFar, i + nums[i]);
                if (nextFar >= nums.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    @Test
    public void test() {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(canJump(nums));
    }
}

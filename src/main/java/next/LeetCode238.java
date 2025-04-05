package next;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

/**
 * @author zhouhao
 * @date 2025/4/5 14:42
 * https://leetcode.cn/problems/product-of-array-except-self/
 */
public class LeetCode238 {
    public int[] productExceptSelf(int[] nums) {
        int[] leftToRight = new int[nums.length];
        int[] rightToLeft = new int[nums.length];
        leftToRight[0] = 1;
        rightToLeft[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            leftToRight[i] = nums[i - 1] * leftToRight[i - 1];
            rightToLeft[nums.length - i - 1] = nums[nums.length - i] * rightToLeft[nums.length - i];
        }
        int[] ans = new int[nums.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = leftToRight[i] * rightToLeft[i];
        }
        return ans;
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 4};
        int[] ans = productExceptSelf(nums);
        assertEquals("[24, 12, 8, 6]", Arrays.toString(ans));
    }
}

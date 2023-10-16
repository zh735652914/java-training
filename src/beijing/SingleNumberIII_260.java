package beijing;

import java.util.Arrays;

/**
 * @author zhouhao
 * @date 2023/10/16 12:35
 */
public class SingleNumberIII_260 {
    static class Solution {
        public int[] singleNumber(int[] nums) {
            int sum = 0;
            for (int num : nums) {
                sum ^= num;
            }
            int[] ans = new int[2];
            int pos = 1;
            while ((sum & 1) == 0) {
                pos <<= 1;
                sum >>= 1;
            }
            for (int num : nums) {
                if ((num & pos) == 0) {
                    ans[0] ^= num;
                } else {
                    ans[1] ^= num;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 2, 5};
        System.out.println(Arrays.toString(new Solution().singleNumber(nums)));
    }
}

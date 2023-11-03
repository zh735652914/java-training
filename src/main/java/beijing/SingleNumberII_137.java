package beijing;
/*
https://leetcode.cn/problems/single-number-ii/?envType=daily-question&envId=2023-10-15
 */

/**
 * @author zhouhao
 * @date 2023/10/15 12:48
 */
public class SingleNumberII_137 {
    // bit数组
    static class Solution {
        public int singleNumber(int[] nums) {
            int ans = 0;
            for (int i = 0; i < 32; i++) {
                int count = 0;
                for (int num : nums) {
                    count += (num >> i) & 1;
                }
                if (count % 3 != 0) {
                    ans |= (1 << i);
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 2};
        System.out.println(new Solution().singleNumber(nums));
    }
}

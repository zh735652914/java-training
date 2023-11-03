package beijing;
/*
https://leetcode.cn/problems/count-nice-pairs-in-an-array/
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhouhao
 * @date 2023/1/17 13:01
 */
// 很离谱的题目
public class CountNicePairs {
    static class Solution {
        public int countNicePairs(int[] nums) {
            final int MOD = 1000000007;
            int count = 0;
            /*
            A+rev(B)=B+rev(A)
            A-rev(A)=B-rev(B)
             */
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                int x = num - rev(num);
                count = (count + map.getOrDefault(x, 0)) % MOD;
                map.put(x, map.getOrDefault(x, 0) + 1);
            }
            return count;
        }

        private int rev(int num) {
            int x = 0;
            while (num > 0) {
                x *= 10;
                x += num % 10;
                num /= 10;
            }
            return x;
        }
    }

    public static void main(String[] args) {
        int[] nums = {42, 11, 1, 97};
        System.out.println(new Solution().countNicePairs(nums));
    }
}

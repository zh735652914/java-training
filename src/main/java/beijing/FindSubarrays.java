package beijing;
/*
https://leetcode.cn/problems/find-subarrays-with-equal-sum/
 */

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhouhao
 * @date 2023/3/26 10:20
 */
public class FindSubarrays {
    // 有长度为2的子数组这个条件的确就很简单了
    static class Solution {
        public boolean findSubarrays(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length - 1; i++) {
                int sum = nums[i] + nums[i + 1];
                if (set.contains(sum)) {
                    return true;
                }
                set.add(sum);
            }
            return false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(new Solution().findSubarrays(nums));
    }
}

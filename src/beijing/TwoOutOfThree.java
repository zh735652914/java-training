package beijing;
/*
https://leetcode.cn/problems/two-out-of-three/
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouhao
 * @date 2022/12/29 13:37
 */
public class TwoOutOfThree {
    // 没想到好的算法
    static class Solution {
        public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
            List<Integer> ans = new ArrayList<>();
            int[] count1 = count(nums1), count2 = count(nums2), count3 = count(nums3);
            for (int i = 1; i <= 100; i++) {
                if (count1[i] + count2[i] + count3[i] > 1) {
                    ans.add(i);
                }
            }
            return ans;
        }

        private int[] count(int[] nums) {
            int[] C = new int[101];
            for (int num : nums) {
                C[num] = 1;
            }
            return C;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 3, 2}, nums2 = {2, 3}, nums3 = {3};
        System.out.println(new Solution().twoOutOfThree(nums1, nums2, nums3));
    }
}

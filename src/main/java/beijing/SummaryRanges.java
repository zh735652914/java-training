package beijing;
/*
https://leetcode.cn/problems/summary-ranges/
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouhao
 * @date 2023/8/26 10:43
 */
public class SummaryRanges {
    // 并不好写
    static class Solution {
        public List<String> summaryRanges(int[] nums) {
            List<String> ans = new ArrayList<>();
            int index = 0;
            while (index < nums.length) {
                int left = nums[index];
                index++;
                while (index < nums.length && nums[index] == nums[index - 1] + 1) {
                    index++;
                }
                int right = nums[index - 1];
                if (left == right) {
                    ans.add(String.valueOf(left));
                } else {
                    String stringBuilder = left +
                            "->" +
                            right;
                    ans.add(stringBuilder);
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 2, 3, 4, 6, 8, 9};
        System.out.println(new Solution().summaryRanges(nums));
    }
}

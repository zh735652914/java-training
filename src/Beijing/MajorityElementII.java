package Beijing;
/*
https://leetcode-cn.com/problems/majority-element-ii/
 */

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
    // 这个算法得看看，自己不会写，比作士兵打仗
    static class Solution {
        public List<Integer> majorityElement(int[] nums) {
            int count = nums.length / 3;
            int vote1 = 0, vote2 = 0;
            int major1 = -1, major2 = -1;
            for (int num : nums) {
                if (vote1 > 0 && major1 == num) {
                    vote1++;
                } else if (vote2 > 0 && major2 == num) {
                    vote2++;
                } else if (vote1 == 0) {
                    major1 = num;
                    vote1++;
                } else if (vote2 == 0) {
                    major2 = num;
                    vote2++;
                } else {
                    vote1--;
                    vote2--;
                }
            }
            int count1 = 0, count2 = 0;
            for (int num : nums) {
                if (vote1 > 0 && num == major1) {
                    count1++;
                }
                if (vote2 > 0 && num == major2) {
                    count2++;
                }
            }
            List<Integer> ans = new ArrayList<>();
            if (count1 > count) {
                ans.add(major1);
            }
            if (count2 > count) {
                ans.add(major2);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
        System.out.println(new Solution().majorityElement(nums));
    }
}

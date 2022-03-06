package Beijing;
/*
https://leetcode-cn.com/problems/find-good-days-to-rob-the-bank/
 */

import java.util.ArrayList;
import java.util.List;

public class goodDaysToRobBank {
    // 两个dp，自己没想到
    static class Solution {
        public List<Integer> goodDaysToRobBank(int[] security, int time) {
            List<Integer> ans = new ArrayList<>();
            int len = security.length;
            int[] left = new int[len];
            int[] right = new int[len];
            for (int i = 1; i < len; i++) {
                left[i] = security[i] <= security[i - 1] ? left[i - 1] + 1 : 0;
                right[len - 1 - i] = security[len - 1 - i] <= security[len - i] ? right[len - i] + 1 : 0;
            }
            for (int i = 0; i < len; i++) {
                if (left[i] >= time && right[i] >= time) {
                    ans.add(i);
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] security = {5, 3, 3, 3, 5, 6, 2};
        int time = 2;
        System.out.println(new Solution().goodDaysToRobBank(security, time));
    }
}

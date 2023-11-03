package beijing;
/*
https://leetcode.cn/problems/maximum-split-of-positive-even-integers/
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouhao
 * @date 2023/7/6 12:23
 */
public class MaximumEvenSplit {
    // 这个贪心要看看
    static class Solution {
        public List<Long> maximumEvenSplit(long finalSum) {
            List<Long> ans = new ArrayList<>();
            if ((finalSum & 1) == 1) {
                return ans;
            }
            for (long i = 2; i <= finalSum; i += 2) {
                ans.add(i);
                finalSum -= i;
            }
            ans.set(ans.size() - 1, ans.get(ans.size() - 1) + finalSum);
            return ans;
        }
    }

    public static void main(String[] args) {
        long finalSum = 12;
        System.out.println(new Solution().maximumEvenSplit(finalSum));
    }
}

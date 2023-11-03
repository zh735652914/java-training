package beijing;
/*
https://leetcode-cn.com/problems/increasing-triplet-subsequence/
 */

public class increasingTriplet {
    static class Solution {
        /*
        a 始终记录最小元素，b 为某个子序列里第二大的数。

        接下来不断更新 a，同时保持 b 尽可能的小。

        如果下一个元素比 b 大，说明找到了三元组。
         */

        public boolean increasingTriplet(int[] nums) {
            int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE;
            for (int num : nums) {
                if (num <= a) {
                    a = num;
                } else if (num <= b) {
                    b = num;
                } else {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 0, 4, 6};
        System.out.println(new Solution().increasingTriplet(nums));
    }
}

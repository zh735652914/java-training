package beijing;
/*
https://leetcode.cn/problems/minimum-cost-to-move-chips-to-the-same-position/
 */

public class minCostToMoveChips {
    // 这题没有意思
    static class Solution {
        public int minCostToMoveChips(int[] position) {
            int odd = 0, even = 0;
            for (int num : position) {
                if ((num & 1) == 1) {
                    odd++;
                } else {
                    even++;
                }
            }
            if (odd >= even) {
                return even;
            } else {
                return odd;
            }
        }
    }

    public static void main(String[] args) {
        int[] position = {1, 2, 3};
        System.out.println(new Solution().minCostToMoveChips(position));
    }
}

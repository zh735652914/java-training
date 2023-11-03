package beijing;
/*
https://leetcode.cn/problems/WHnhjV/?envType=daily-question&envId=2023-09-15
 */

/**
 * @author zhouhao
 * @date 2023/9/15 12:27
 */
public class GiveGem {
    // 简单模拟
    static class Solution {
        public int giveGem(int[] gem, int[][] operations) {
            for (int[] opreation : operations) {
                int num = gem[opreation[0]] / 2;
                gem[opreation[1]] += num;
                gem[opreation[0]] -= num;
            }
            int max = gem[0], min = gem[0];
            for (int x : gem) {
                max = Math.max(max, x);
                min = Math.min(min, x);
            }
            return max - min;
        }
    }

    public static void main(String[] args) {
        int[] gem = {3, 1, 2};
        int[][] operations = {{0, 2}, {2, 1}, {2, 0}};
        System.out.println(new Solution().giveGem(gem, operations));
    }
}

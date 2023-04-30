package beijing;
/*
https://leetcode.cn/problems/moving-stones-until-consecutive/
 */

import java.util.Arrays;

/**
 * @author zhouhao
 * @date 2023/4/30 13:31
 */
public class NumMovesStones {
    // 脑筋急转弯？？？
    static class Solution {
        public int[] numMovesStones(int a, int b, int c) {
            int x = Math.min(a, Math.min(b, c));
            int z = Math.max(a, Math.max(b, c));
            int y = a + b + c - x - z;
            int[] ans = new int[2];
            ans[1] = z - x - 2;
            ans[0] = 2;
            if (z - y == 1 && y - x == 1) {
                // 针对有两个数字中间只间隔一的情况
                ans[0] = 0;
            } else if (y - x <= 2 || z - y <= 2) {
                ans[0] = 1;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int a = 3, b = 5, c = 1;
        System.out.println(Arrays.toString(new Solution().numMovesStones(a, b, c)));
    }
}

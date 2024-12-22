package next;
/**
 * https://leetcode.cn/problems/sort-integers-by-the-power-value/?envType=daily-question&envId=2024-12-22
 */

import java.util.Arrays;

/**
 * @author zhouhao
 * @date 2024/12/22 11:33
 */
public class GetKth {
    static class Solution {
        public int getKth(int lo, int hi, int k) {
            int[][] nums = new int[hi - lo + 1][2];
            for (int i = 0; i <= (hi - lo); i++) {
                nums[i][0] = lo + i;
                nums[i][1] = count(lo + i);
            }
            Arrays.sort(nums, (o1, o2) -> {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            });
            return nums[k - 1][0];
        }

        private int count(int x) {
            if (x == 1) {
                return 0;
            }
            if ((x & 1) == 1) {
                return count(3 * x + 1) + 1;
            } else {
                return count(x / 2) + 1;
            }
        }
    }

    public static void main(String[] args) {
        int lo = 12, hi = 15, k = 2;
        System.out.println(new Solution().getKth(lo, hi, k));
    }
}

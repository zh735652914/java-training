package next;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author zhouhao
 * @date 2025/3/22 10:02
 * https://leetcode.cn/problems/row-with-maximum-ones/?envType=daily-question&envId=2025-03-22
 */
public class LeetCode2643 {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int[] ans = new int[2];
        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int num : mat[i]) {
                if (num == 1) {
                    count++;
                }
            }
            if (count > ans[1]) {
                ans[0] = i;
                ans[1] = count;
            }
        }
        return ans;
    }

    @Test
    public void test() {
        int[][] mat = {
                {0, 0, 0},
                {0, 1, 1}
        };
        System.out.println(Arrays.toString(rowAndMaximumOnes(mat)));
    }
}

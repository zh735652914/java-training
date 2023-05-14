package beijing;
/*
https://leetcode.cn/problems/distant-barcodes/
 */

import java.util.Arrays;

/**
 * @author zhouhao
 * @date 2023/5/14 15:06
 */
public class RearrangeBarcodes {
    public static void main(String[] args) {
        int[] barcodes = {1, 1, 1, 2, 2, 2};
        int[] ans = new Solution().rearrangeBarcodes(barcodes);
        System.out.println(Arrays.toString(ans));
    }

    // 自己不会写的数学问题
    static class Solution {
        public int[] rearrangeBarcodes(int[] barcodes) {
            int[] ans = new int[barcodes.length];
            Integer[] tmp = new Integer[barcodes.length];
            int maxNum = 0;
            for (int i = 0; i < barcodes.length; i++) {
                tmp[i] = barcodes[i];
                maxNum = Math.max(maxNum, barcodes[i]);
            }
            int[] counts = new int[maxNum + 1];
            for (int num : barcodes) {
                counts[num]++;
            }
            Arrays.sort(tmp, (a, b) -> counts[a] == counts[b] ? a - b : counts[b] - counts[a]);
            int index = 0;
            for (int i = 0; i < ans.length; i += 2) {
                ans[i] = tmp[index++];
            }
            for (int i = 1; i < ans.length; i += 2) {
                ans[i] = tmp[index++];
            }
            return ans;
        }
    }
}

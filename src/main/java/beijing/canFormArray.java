package beijing;
/*
https://leetcode.cn/problems/check-array-formation-through-concatenation/
 */

import java.util.HashMap;
import java.util.Map;

public class canFormArray {
    // 写起来不是那么顺手
    static class Solution {
        public boolean canFormArray(int[] arr, int[][] pieces) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < pieces.length; i++) {
                map.put(pieces[i][0], i);
            }
            int i;
            for (i = 0; i < arr.length; i++) {
                if (!map.containsKey(arr[i])) {
                    return false;
                }
                int[] piece = pieces[map.get(arr[i])];
                int j = 0;
                while (i < arr.length && j < piece.length && arr[i] == piece[j]) {
                    i++;
                    j++;
                }
                if (j != piece.length) {
                    return false;
                }
                i--;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        int[] arr = {91, 4, 64, 78};
        int[][] pieces = {{78}, {4, 64}, {91}};
        System.out.println(new Solution().canFormArray(arr, pieces));
    }
}

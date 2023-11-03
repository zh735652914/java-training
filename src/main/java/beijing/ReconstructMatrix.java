package beijing;
/*
https://leetcode.cn/problems/reconstruct-a-2-row-binary-matrix/
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouhao
 * @date 2023/6/29 13:16
 */
public class ReconstructMatrix {
    // 看了解析才会
    static class Solution {
        public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
            int sum = 0, two = 0;
            for (int x : colsum) {
                if (x == 2) {
                    two++;
                }
                sum += x;
            }
            if (sum != (upper + lower) || two > Math.min(upper, lower)) {
                return new ArrayList<>();
            }
            List<List<Integer>> ans = new ArrayList<>();
            for (int i = 0; i < 2; i++) {
                ans.add(new ArrayList<>());
            }
            upper -= two;
            lower -= two;
            for (int x : colsum) {
                if (x == 0) {
                    ans.get(0).add(0);
                    ans.get(1).add(0);
                } else if (x == 1) {
                    if (upper > 0) {
                        ans.get(0).add(1);
                        ans.get(1).add(0);
                        upper--;
                    } else {
                        ans.get(0).add(0);
                        ans.get(1).add(1);
                        lower--;
                    }
                } else if (x == 2) {
                    ans.get(0).add(1);
                    ans.get(1).add(1);
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int upper = 2, lower = 1;
        int[] colsum = {1, 1, 1};
        System.out.println(new Solution().reconstructMatrix(upper, lower, colsum));
    }
}

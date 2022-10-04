package Beijing;
/*
https://leetcode.cn/problems/pascals-triangle/
 */

import java.util.ArrayList;
import java.util.List;

// 官方解答更好
public class Triangle_118_topInterviewList {
    static class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> ans = new ArrayList<>();
            for (int i = 0; i < numRows; i++) {
                List<Integer> row = new ArrayList<>();
                for (int j = 0; j <= i; j++) {
                    if (j == 0 || i == j) {
                        row.add(1);
                    } else {
                        row.add(ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
                    }
                }
                ans.add(row);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int numRows = 5;
        System.out.println(new Solution().generate(numRows));
    }
}

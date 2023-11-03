package beijing;
/*
https://leetcode-cn.com/problems/pascals-triangle/
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 这很简单
public class PascalTriangle {
    static class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> ans = new LinkedList<>();
            List<Integer> lastRow = new ArrayList<>();
            lastRow.add(1);
            ans.add(lastRow);
            while (--numRows > 0) {
                List<Integer> thisRow = genRow(lastRow);
                ans.add(thisRow);
                lastRow = thisRow;
            }
            return ans;
        }

        private List<Integer> genRow(List<Integer> lastRow) {
            List<Integer> nextRow = new ArrayList<>(lastRow.size() + 1);
            for (int i = 0; i < lastRow.size() + 1; i++) {
                if (i == 0) {
                    nextRow.add(lastRow.get(i));
                    continue;
                }
                if (i == lastRow.size()) {
                    nextRow.add(lastRow.get(i - 1));
                    continue;
                }
                nextRow.add(lastRow.get(i) + lastRow.get(i - 1));
            }
            return nextRow;
        }
    }

    public static void main(String[] args) {
        int numRows = 5;
        System.out.println(new Solution().generate(numRows));
    }
}

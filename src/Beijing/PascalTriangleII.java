package Beijing;
/*
https://leetcode-cn.com/problems/pascals-triangle-ii/
 */

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {
    // 这个解法我居然不会写
    static class Solution {
        public List<Integer> getRow(int rowIndex) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int i = 1; i <= rowIndex; i++) {
                row.add(0);
                for (int j = i; j > 0; j--) {
                    row.set(j, row.get(j) + row.get(j - 1));
                }
            }
            return row;
        }
    }

    // 1,2,1
    public static void main(String[] args) {
        int rowIndex = 3;
        System.out.println(new Solution().getRow(rowIndex));
    }
}

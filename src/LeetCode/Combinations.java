package LeetCode;
/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 */
/*
!!!!!重要！！！！自己写不会！！！！
 */

import java.util.ArrayList;
import java.util.List;

class CombinationsSolution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        bracktrack(ans, new ArrayList<Integer>(), n, k, 1);
        return ans;
    }

    private void bracktrack(List<List<Integer>> ans, List<Integer> aAns, int n, int k, int start) {
        if (k == 0) {
            ans.add(new ArrayList<>(aAns));
            return;
        }
        for (int i = start; i <= n; i++) {
            aAns.add(i);
            bracktrack(ans, aAns, n, k - 1, i + 1);
            aAns.remove(aAns.size() - 1);
        }
    }
}

public class Combinations {
    public static void main(String[] args) {
        int n = 4, k = 2;
        CombinationsSolution CS = new CombinationsSolution();
        List<List<Integer>> ans = CS.combine(n, k);
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }
}

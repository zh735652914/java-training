package leetcode;
/*
454. 4Sum II
Medium

924

68

Add to List

Share
Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l)
there are such that A[i] + B[j] + C[k] + D[l] is zero.

To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500.
All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.

Example:

Input:
A = [ 1, 2]
B = [-2,-1]
C = [-1, 2]
D = [ 0, 2]

Output:
2

Explanation:
The two tuples are:
1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 */

import java.util.HashMap;
import java.util.Map;

//不难，但是自己没想到这样写。。。
public class fourSumCount {
    static class fourSumCountSolution {
        public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int valueA : A) {
                for (int valueB : B) {
                    int sum = valueA + valueB;
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }
            int ans = 0;
            for (int valueC : C) {
                for (int valueD : D) {
                    int sum = -(valueC + valueD);
                    if (map.containsKey(sum)) {
                        ans += map.get(sum);
                    }
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] A = {1, 2}, B = {-2, -1}, C = {-1, 2}, D = {0, 2};
        System.out.println(new fourSumCountSolution().fourSumCount(A, B, C, D));
    }
}

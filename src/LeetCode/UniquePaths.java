package LeetCode;
/*

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time.
The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?


Above is a 7 x 3 grid. How many possible unique paths are there?

Note: m and n will be at most 100.

Example 1:

Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Right -> Down
2. Right -> Down -> Right
3. Down -> Right -> Right
Example 2:

Input: m = 7, n = 3
Output: 28

 */

/*
牛逼啊！！！！
For the eg., given in question, 3x7 matrix, robot needs to take 2+6 = 8 steps with 2 down and 6 right in any order.
That is nothing but a permutation problem. Denote down as 'D' and right as 'R', following is one of the path :-
D R R R D R R R
Total permutations = (m+n)! / (m! * n!)
 */

class UniquePathsSolutin {
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) return 1;
        m--;
        n--;
        if (m < n) {
            int tmp = m;
            m = n;
            n = tmp;
        }
        long ans = 1;
        for (int i = m + 1, j = 1; i <= (m + n); i++, j++) {
            ans *= i;
            ans /= j;
        }
        return (int) ans;
    }
}

public class UniquePaths {
    public static void main(String[] args) {
        int m = 7, n = 3;
        UniquePathsSolutin UP = new UniquePathsSolutin();
        System.out.println(UP.uniquePaths(m, n));
    }
}

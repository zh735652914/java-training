package LeetCode;
/*
Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

Example:

Input: 3
Output: 5
Explanation:
Given n = 3, there are a total of 5 unique BST's:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 */

class UniqueBinarySearchTreesSolution {
    public int numTrees(int n) {
        if (n == 0) return 0;
        if (n <= 2) return n;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int len = 3; len <= n; len++) {
            for (int root = 1; root <= len; root++) {
                int L = dp[root - 1];
                int R = dp[len - root];
                dp[len] += L * R;
            }
        }
        return dp[n];
    }
}

public class UniqueBinarySearchTrees {
    public static void main(String[] args) {
        int n = 2;
        UniqueBinarySearchTreesSolution UBST = new UniqueBinarySearchTreesSolution();
        System.out.println(UBST.numTrees(n));
    }
}

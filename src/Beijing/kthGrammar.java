package Beijing;
/*
https://leetcode.cn/problems/k-th-symbol-in-grammar/
 */

public class kthGrammar {
    // 自己不会
    static class Solution {
        public int kthGrammar(int n, int k) {
            if (n == 1) {
                return 0;
            }
            int root = kthGrammar(n - 1, (k + 1) >> 1);
            return (k & 1) == 1 ? root : root ^ 1;
        }
    }

    public static void main(String[] args) {
        int n = 2, k = 2;
        System.out.println(new Solution().kthGrammar(n, k));
    }
}

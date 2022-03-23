package Beijing;
/*
https://leetcode-cn.com/problems/k-th-smallest-in-lexicographical-order/
 */

// 自己不会，这字典树，还是有点意思的。
public class findKthNumber {
    static class Solution {
        public int findKthNumber(int n, int k) {
            int cur = 1;
            k--;
            while (k > 0) {
                int count = getNums(cur, n);
                if (count <= k) {
                    k -= count;
                    cur++;
                } else {
                    k--;
                    cur *= 10;
                }
            }
            return cur;
        }

        private int getNums(int cur, int n) {
            int count = 0;
            long left = cur;
            long right = cur;
            while (left <= n) {
                count += Math.min(right, n) - left + 1;
                left *= 10;
                right = 10 * right + 9;
            }
            return count;
        }
    }

    public static void main(String[] args) {
        int n = 13, k = 2;
        System.out.println(new Solution().findKthNumber(n, k));
    }
}

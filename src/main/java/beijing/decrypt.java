package beijing;
/*
https://leetcode.cn/problems/defuse-the-bomb/
 */

public class decrypt {
    // 这种方法自己不会写
    static class Solution {
        public int[] decrypt(int[] code, int k) {
            int n = code.length;
            if (k == 0) {
                return new int[n];
            }
            int[] ans = new int[n];
            int[] newCode = new int[n * 2];
            System.arraycopy(code, 0, newCode, 0, n);
            System.arraycopy(code, 0, newCode, n, n);
            code = newCode;
            int left = k > 0 ? 1 : n + k;
            int right = k > 0 ? k : n - 1;
            int sum = 0;
            for (int i = left; i <= right; i++) {
                sum += code[i];
            }
            for (int i = 0; i < n; i++) {
                ans[i] = sum;
                sum -= code[left];
                sum += code[right + 1];
                left++;
                right++;
            }
            return ans;
        }
    }

    // 自己写的，效率有点低
    static class Solution0 {
        public int[] decrypt(int[] code, int k) {
            int[] ans = new int[code.length];
            for (int i = 0; i < ans.length; i++) {
                for (int j = 1; j <= Math.abs(k); j++) {
                    if (k > 0) {
                        ans[i] += code[(i + j) % ans.length];
                    } else {
                        ans[i] += code[(i - j + ans.length) % ans.length];
                    }
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] code = {2, 4, 9, 3};
        int k = -2;
        int[] ans = new Solution().decrypt(code, k);
        for (int num : ans) {
            System.out.print(num + ", ");
        }
    }
}

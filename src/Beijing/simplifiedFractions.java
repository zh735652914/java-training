package Beijing;
/*
https://leetcode-cn.com/problems/simplified-fractions/
 */

import java.util.LinkedList;
import java.util.List;

public class simplifiedFractions {
    static class Solution {
        public List<String> simplifiedFractions(int n) {
            List<String> ans = new LinkedList<>();
            for (int i = 2; i <= n; i++) {
                for (int j = 1; j < i; j++) {
                    if (gcd(i, j) == 1) {
                        ans.add(j + "/" + i);
                    }
                }
            }
            return ans;
        }

        // 求最大公约数
        private int gcd(int a, int b) {
            return b == 0 ? a : gcd(b, a % b);
        }
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(new Solution().simplifiedFractions(n));
    }
}

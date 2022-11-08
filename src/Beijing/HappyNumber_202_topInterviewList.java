package Beijing;
/*
https://leetcode.cn/problems/happy-number/
 */

import java.util.HashSet;
import java.util.Set;

public class HappyNumber_202_topInterviewList {
    // 注意循环小数
    static class Solution {
        public boolean isHappy(int n) {
            Set<Integer> set = new HashSet<>();
            while (true) {
                int sum = 0;
                while (n > 0) {
                    int x = n % 10;
                    sum += x * x;
                    n /= 10;
                }
                if (sum == 1) {
                    break;
                }
                if (set.contains(sum)) {
                    return false;
                }
                set.add(sum);
                n = sum;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        int n = 19;
        System.out.println(new Solution().isHappy(n));
    }
}

package beijing;
/*
https://leetcode.cn/problems/happy-number/
 */

import java.util.HashSet;
import java.util.Set;

// 这题也很简单
public class happyNumber {
    static class Solution {
        public boolean isHappy(int n) {
            if (n <= 0) {
                return false;
            }
            Set<Integer> set = new HashSet<>();
            while (n != 1) {
                if (set.contains(n)) {
                    return false;
                }
                set.add(n);
                int next = 0;
                while (n > 0) {
                    int num = n % 10;
                    n /= 10;
                    next += num * num;
                }
                n = next;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        int n = 2;
        System.out.println(new Solution().isHappy(n));
    }
}

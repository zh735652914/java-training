package Beijing;
/*
https://leetcode-cn.com/problems/self-dividing-numbers/
 */

import java.util.ArrayList;
import java.util.List;

public class selfDividingNumbers {
    // 这题很简单
    static class Solution {
        public List<Integer> selfDividingNumbers(int left, int right) {
            List<Integer> ans = new ArrayList<>();
            while (left <= right) {
                if (isSelf(left)) {
                    ans.add(left);
                }
                left++;
            }
            return ans;
        }

        private boolean isSelf(int x) {
            int tmp = x;
            while (tmp > 0) {
                int digit = tmp % 10;
                tmp /= 10;
                if (digit == 0 || x % digit != 0) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        int left = 47, right = 85;
        System.out.println(new Solution().selfDividingNumbers(left, right));
    }
}

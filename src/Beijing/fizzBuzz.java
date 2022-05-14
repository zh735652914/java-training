package Beijing;
/*
https://leetcode.cn/problems/fizz-buzz/
 */

import java.util.ArrayList;
import java.util.List;

// 这题很简单
public class fizzBuzz {
    static class Solution {
        public List<String> fizzBuzz(int n) {
            List<String> ans = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                int a = i % 3, b = i % 5;
                if (a != 0 && b != 0) {
                    ans.add(String.valueOf(i));
                } else if (b != 0) {
                    ans.add("Fizz");
                } else if (a != 0) {
                    ans.add("Buzz");
                } else {
                    ans.add("FizzBuzz");
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(new Solution().fizzBuzz(n));
    }
}

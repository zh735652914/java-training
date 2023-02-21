package beijing;
/*
https://leetcode.cn/problems/fizz-buzz/
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouhao
 * @date 2023/2/21 12:56
 */
public class FizzBuzz_412_topInterviewList {
    static class Solution {
        public List<String> fizzBuzz(int n) {
            List<String> ans = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                boolean x = i % 3 == 0;
                boolean y = i % 5 == 0;
                if (x && y) {
                    ans.add("FizzBuzz");
                } else if (x) {
                    ans.add("Fizz");
                } else if (y) {
                    ans.add("Buzz");
                } else {
                    ans.add(String.valueOf(i));
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

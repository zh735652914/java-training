package beijing;
/*
https://leetcode.cn/problems/gray-code/
 */

import java.util.ArrayList;
import java.util.List;

// 第二次了，还是不会写
public class grayCode_89 {
    static class Solution {
        public List<Integer> grayCode(int n) {
            List<Integer> ans = new ArrayList<>();
            int len = 1 << n;
            for (int i = 0; i < len; i++) {
                ans.add(i ^ (i >> 1));
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int n = 2;
        System.out.println(new Solution().grayCode(n));
    }
}

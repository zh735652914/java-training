package beijing;
/*
https://leetcode.cn/problems/maximum-value-of-a-string-in-an-array/
 */

/**
 * @author zhouhao
 * @date 2023/6/23 14:02
 */
public class MaximumValue {
    // 这种写法很简单
    static class Solution {
        public int maximumValue(String[] strs) {
            int ans = 0;
            for (String str : strs) {
                try {
                    ans = Math.max(ans, Integer.parseInt(str));
                } catch (Exception e) {
                    ans = Math.max(ans, str.length());
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        String[] strs = {"alic3", "bob", "3", "4", "00000"};
        System.out.println(new Solution().maximumValue(strs));
    }
}

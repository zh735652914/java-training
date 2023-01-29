package beijing;
/*
https://leetcode.cn/problems/swap-adjacent-in-lr-string/
 */

public class canTransform {
    // 自己不会写
    static class Solution {
        public boolean canTransform(String start, String end) {
            int n = start.length();
            int s_index = 0, e_index = 0;
            while (s_index < n && e_index < n) {
                while (s_index < n && start.charAt(s_index) == 'X') {
                    s_index++;
                }
                while (e_index < n && end.charAt(e_index) == 'X') {
                    e_index++;
                }
                if (s_index < n && e_index < n) {
                    if (start.charAt(s_index) != end.charAt(e_index)) {
                        return false;
                    }
                    if (start.charAt(s_index) == 'L' && s_index < e_index) {
                        return false;
                    }
                    if (start.charAt(s_index) == 'R' && s_index > e_index) {
                        return false;
                    }
                    s_index++;
                    e_index++;
                }
            }
            while (s_index < n) {
                if (start.charAt(s_index++) != 'X') {
                    return false;
                }
            }
            while (e_index < n) {
                if (end.charAt(e_index++) != 'X') {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        String start = "X", end = "L";
        System.out.println(new Solution().canTransform(start, end));
    }
}

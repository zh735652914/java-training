package beijing;
/*
https://leetcode-cn.com/problems/rotate-string/
 */

public class rotateString {
    // 这题我都不知道说什么好
    static class Solution {
        public boolean rotateString(String s, String goal) {
            if (s.length() != goal.length()) {
                return false;
            }
            return (s + s).contains(goal);
        }
    }

    public static void main(String[] args) {
        String s = "abcde", goal = "cdeab";
        System.out.println(new Solution().rotateString(s, goal));
    }
}

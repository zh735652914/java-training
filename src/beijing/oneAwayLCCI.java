package beijing;
/*
https://leetcode.cn/problems/one-away-lcci/
 */

public class oneAwayLCCI {
    // 两年前写过的题目不会了
    static class Solution {
        public boolean oneEditAway(String first, String second) {
            if (Math.abs(first.length() - second.length()) >= 2) {
                return false;
            }
            boolean diff = false;
            int lenA = first.length(), lenB = second.length();
            for (int i = 0, j = 0; i < lenA && j < lenB; i++, j++) {
                if (first.charAt(i) == second.charAt(j)) {
                    continue;
                } else {
                    if (diff) {
                        return false;
                    } else {
                        diff = true;
                        if (lenA == lenB) {
                            continue;
                        } else if (lenA < lenB) {
                            i--;
                        } else {
                            j--;
                        }
                    }
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        String first = "ab", second = "bc";
        System.out.println(new Solution().oneEditAway(first, second));
    }
}

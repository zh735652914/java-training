package Beijing;
/*
https://leetcode.cn/problems/longest-uncommon-subsequence-ii/
 */

// 自己不会写，看了解析才会
public class findLUSlengthII {
    static class Solution {
        public int findLUSlength(String[] strs) {
            int ans = -1;
            for (int i = 0; i < strs.length; i++) {
                boolean check = true;
                for (int j = 0; j < strs.length; j++) {
                    if (i != j && isSub(strs[i], strs[j])) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    ans = Math.max(ans, strs[i].length());
                }
            }
            return ans;
        }

        private boolean isSub(String s, String t) {
            int lenS = s.length(), lenT = t.length();
            int indexS = 0, indexT = 0;
            while (indexS < lenS && indexT < lenT) {
                if (s.charAt(indexS) == t.charAt(indexT)) {
                    indexS++;
                }
                indexT++;
            }
            return indexS == lenS;
        }
    }

    public static void main(String[] args) {
        String[] strs = {"aba", "cdc", "eae"};
        System.out.println(new Solution().findLUSlength(strs));
    }
}

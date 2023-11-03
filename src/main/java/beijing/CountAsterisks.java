package beijing;
/*
https://leetcode.cn/problems/count-asterisks/
 */

/**
 * @author zhouhao
 * @date 2023/1/29 12:53
 */

// 不难，有点生疏了
public class CountAsterisks {
    static class Solution {
        public int countAsterisks(String s) {
            int xCount = 0, count = 0, ans = 0;
            int len = s.length();
            for (int i = 0; i < len; i++) {
                if (s.charAt(i) == '|') {
                    xCount++;
                    if ((xCount & 1) == 1) {
                        ans += count;
                    }
                    count = 0;
                } else if (s.charAt(i) == '*') {
                    count++;
                }
            }
            return ans + count;
        }
    }

    public static void main(String[] args) {
        String s = "*&||&||**&||*&||**&|**|&|*|&||**&";
        System.out.println(new Solution().countAsterisks(s));
    }
}

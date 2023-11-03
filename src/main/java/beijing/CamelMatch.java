package beijing;
/*
https://leetcode.cn/problems/camelcase-matching/
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouhao
 * @date 2023/4/14 12:42
 */

// 自己一开始没有思路
public class CamelMatch {
    static class Solution {
        public List<Boolean> camelMatch(String[] queries, String pattern) {
            List<Boolean> ans = new ArrayList<>();
            for (String query : queries) {
                ans.add(isMatch(query, pattern));
            }
            return ans;
        }

        private boolean isMatch(String query, String pattern) {
            int p = 0, q = 0, lenQ = query.length(), lenP = pattern.length();
            while (q < lenQ) {
                if (p >= lenP) {
                    if (Character.isUpperCase(query.charAt(q))) {
                        return false;
                    } else {
                        q++;
                    }
                    continue;
                }
                if (query.charAt(q) == pattern.charAt(p)) {
                    p++;
                    q++;
                } else if (Character.isUpperCase(query.charAt(q))) {
                    return false;
                } else {
                    q++;
                }
            }
            return p >= lenP;
        }
    }

    public static void main(String[] args) {
        String[] queries = {"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"};
        String pattern = "FoBa";
        System.out.println(new Solution().camelMatch(queries, pattern));
    }
}

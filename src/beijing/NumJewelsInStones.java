package beijing;
/*
https://leetcode.cn/problems/jewels-and-stones/
 */

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhouhao
 * @date 2023/7/24 11:49
 */
public class NumJewelsInStones {
    // 很简单
    static class Solution {
        public int numJewelsInStones(String jewels, String stones) {
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < jewels.length(); i++) {
                set.add(jewels.charAt(i));
            }
            int ans = 0;
            for (int i = 0; i < stones.length(); i++) {
                if (set.contains(stones.charAt(i))) {
                    ans++;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        String jewels = "aA", stones = "aAAbbbb";
        System.out.println(new Solution().numJewelsInStones(jewels, stones));
    }
}

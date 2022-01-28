package Beijing;
/*
https://leetcode-cn.com/problems/the-number-of-weak-characters-in-the-game/
 */

import java.util.Arrays;

public class numberOfWeakCharacters {
    // 排序的方法的多看看
    static class Solution {
        public int numberOfWeakCharacters(int[][] properties) {
            if (properties.length < 1) {
                return 0;
            }
            Arrays.sort(properties, ((o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]));
            int last = properties[0][1];
            int ans = 0;
            for (int i = 1; i < properties.length; i++) {
                if (last > properties[i][1]) {
                    ans++;
                }
                last = Math.max(properties[i][1], last);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[][] properties = {{1, 5}, {10, 4}, {4, 3}};
        System.out.println(new Solution().numberOfWeakCharacters(properties));
    }
}

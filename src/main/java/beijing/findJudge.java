package beijing;

/*
https://leetcode-cn.com/problems/find-the-town-judge/
 */
public class findJudge {
    static class Solution {
        public int findJudge(int n, int[][] trust) {
            if (n < 2) {
                return n;
            }
            int[] count = new int[n + 1];
            for (int i = 0; i < trust.length; i++) {
                count[trust[i][1]]++;
                count[trust[i][0]] = Integer.MIN_VALUE;
            }
            for (int i = 0; i < count.length; i++) {
                if (count[i] >= n - 1) {
                    return i;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        int[][] trust = {{1, 3}, {2, 3}, {3, 1}};
        int n = 3;
        System.out.println(new Solution().findJudge(n, trust));
    }
}

package Beijing;
/*
https://leetcode-cn.com/problems/find-center-of-star-graph/
 */

public class findCenter {
    static class Solution {
        public int findCenter(int[][] edges) {
            int[] nums = new int[edges.length + 2];
            for (int[] edge : edges) {
                nums[edge[0]]++;
                nums[edge[1]]++;
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == edges.length) {
                    return i;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        int[][] edges = {{1, 2}, {2, 3}, {4, 2}};
        System.out.println(new Solution().findCenter(edges));
    }
}

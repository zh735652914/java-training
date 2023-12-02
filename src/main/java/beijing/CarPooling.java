package beijing;
/*
https://leetcode.cn/problems/car-pooling/?envType=daily-question&envId=2023-12-02
 */

/**
 * @author zhouhao
 * @date 2023/12/2 15:36
 */
public class CarPooling {
    static class Solution {
        public boolean carPooling(int[][] trips, int capacity) {
            int maxLen = 0;
            for (int[] trip : trips) {
                maxLen = Math.max(maxLen, trip[2]);
            }
            int[] diff = new int[maxLen + 1];
            for (int[] trip : trips) {
                diff[trip[1]] += trip[0];
                diff[trip[2]] -= trip[0];
            }
            int sum = 0;
            for (int x : diff) {
                sum += x;
                if (sum > capacity) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        int[][] trips = {{2, 1, 5}, {3, 3, 7}};
        int capacity = 4;
        System.out.println(new Solution().carPooling(trips, capacity));
    }
}

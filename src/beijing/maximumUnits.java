package beijing;
/*
https://leetcode.cn/problems/maximum-units-on-a-truck/
 */

import java.util.Arrays;

public class maximumUnits {
    // 贪心
    static class Solution {
        public int maximumUnits(int[][] boxTypes, int truckSize) {
            Arrays.sort(boxTypes, (o1, o2) -> {
                return o2[1] - o1[1];
            });
            int ans = 0, count = 0;
            for (int[] boxType : boxTypes) {
                if (count >= truckSize) {
                    break;
                }
                if (count + boxType[0] <= truckSize) {
                    ans += boxType[0] * boxType[1];
                    count += boxType[0];
                } else {
                    ans += boxType[1] * (truckSize - count);
                    break;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[][] boxTypes = {{5, 10}, {2, 5}, {4, 7}, {3, 9}};
        int truckSize = 10;
        System.out.println(new Solution().maximumUnits(boxTypes, truckSize));
    }
}

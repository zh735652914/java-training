package Beijing;
/*
https://leetcode.cn/problems/gas-station/
 */

public class gasStation_134_topInterviewList {
    // 自己还是不会写
    static class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int n = gas.length;
            int start = 0;
            while (start < n) {
                int sumGas = 0, sumCost = 0;
                int count = 0, index = 0;
                while (count < n) {
                    index = (start + count) % n;
                    sumGas += gas[index];
                    sumCost += cost[index];
                    if (sumCost > sumGas) {
                        break;
                    }
                    count++;
                }
                if (count >= n) {
                    return start;
                }
                start += count + 1;
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println(new Solution().canCompleteCircuit(gas, cost));
    }
}

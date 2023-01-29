package beijing;
/*
https://leetcode-cn.com/problems/gas-station/
 */

// 为什么自己写的就不对？？？？？？？？？？？
public class GasStation {
    static class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int start = 0;
            int n = gas.length;
            while (start < n) {
                int curGas = 0;
                int count = 0;
                while (count < n) {
                    int cur = (start + count) % n;
                    curGas += (gas[cur] - cost[cur]);
                    if (curGas < 0) {
                        break;
                    }
                    count++;
                }
                if (count >= n) {
                    return start;
                }
                start = start + count + 1;
            }
            return -1;
        }
    }

    public static void main(String[] args) {
//        int[] gas = {1, 2, 3, 4, 5};
//        int[] cost = {3, 4, 5, 1, 2};
        // {-2,-2,-2,3,3}
        int[] gas = {2, 3, 4};
        int[] cost = {3, 4, 3};
        System.out.println(new Solution().canCompleteCircuit(gas, cost));
    }
}

package leetcode;
/*
134. Gas Station
Medium

1096

334

Add to List

Share
There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1.

Note:

If there exists a solution, it is guaranteed to be unique.
Both input arrays are non-empty and have the same length.
Each element in the input arrays is a non-negative integer.
Example 1:

Input:
gas  = [1,2,3,4,5]
cost = [3,4,5,1,2]

Output: 3

Explanation:
Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
Travel to station 4. Your tank = 4 - 1 + 5 = 8
Travel to station 0. Your tank = 8 - 2 + 1 = 7
Travel to station 1. Your tank = 7 - 3 + 2 = 6
Travel to station 2. Your tank = 6 - 4 + 3 = 5
Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
Therefore, return 3 as the starting index.
Example 2:

Input:
gas  = [2,3,4]
cost = [3,4,3]

Output: -1

Explanation:
You can't start at station 0 or 1, as there is not enough gas to travel to the next station.
Let's start at station 2 and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
Travel to station 0. Your tank = 4 - 3 + 2 = 3
Travel to station 1. Your tank = 3 - 3 + 3 = 3
You cannot travel back to station 2, as it requires 4 unit of gas but you only have 3.
Therefore, you can't travel around the circuit once no matter where you start.
 */

class GasStationSolution {
    //自己写的，但是速度太慢。。。
    // Runtime: 149 ms, faster than 5.15% of Java online submissions for Gas Station.
    //Memory Usage: 36.5 MB, less than 100.00% of Java online submissions for Gas Station.
    public int canCompleteCircuit0(int[] gas, int[] cost) {
        int len = 0, reserve = 0, start = 0;
        for (start = 0; start < gas.length; start++) {
            int pos = start;
            while (len < gas.length) {
                reserve += gas[pos];
                reserve -= cost[pos];
                len++;
                if (reserve < 0) break;
                pos++;
                pos = pos % gas.length;
            }
            if (len >= gas.length && reserve < 0) return -1;
            if (reserve >= 0) break;
            reserve = 0;
            len = 0;
        }
        if (start >= gas.length) return -1;
        return start;
    }

    //看了Discuss后写的。。。果然牛逼，自己的思路问题不大，就是要修改一下
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tank = 0, GasSum = 0, CostSum = 0, start = 0;
        for (int i = 0; i < gas.length; i++) {
            GasSum += gas[i];
            CostSum += cost[i];
            tank += gas[i] - cost[i];
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        return GasSum >= CostSum ? start : -1;
    }
}

public class GasStation {
    public static void main(String[] args) {
//        int[] gas = {1, 2, 3, 4, 5};
//        int[] cost = {3, 4, 5, 1, 2};
//        int[] gas = {2, 3, 4};
//        int[] cost = {3, 4, 3};
        int[] gas = {1, 2, 3, 4, 3, 2, 4, 1, 5, 3, 2, 4};
        int[] cost = {1, 1, 1, 3, 2, 4, 3, 6, 7, 4, 3, 1};
        System.out.println(new GasStationSolution().canCompleteCircuit(gas, cost));
    }
}

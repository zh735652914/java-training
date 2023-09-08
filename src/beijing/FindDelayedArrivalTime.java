package beijing;
/*
https://leetcode.cn/problems/calculate-delayed-arrival-time/?envType=daily-question&envId=2023-09-08
 */

/**
 * @author zhouhao
 * @date 2023/9/8 22:13
 */
public class FindDelayedArrivalTime {
    // 很简单的题目
    static class Solution {
        public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
            return (arrivalTime + delayedTime) % 24;
        }
    }

    public static void main(String[] args) {
        int arrivalTime = 13, delayedTime = 11;
        System.out.println(new Solution().findDelayedArrivalTime(arrivalTime, delayedTime));
    }
}

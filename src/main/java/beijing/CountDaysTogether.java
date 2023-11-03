package beijing;
/*
https://leetcode.cn/problems/count-days-spent-together/
 */

/**
 * @author zhouhao
 * @date 2023/4/17 12:43
 */
public class CountDaysTogether {
    // 按照这个思路来写就很简单了
    static class Solution {
        private final int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
            int left = Math.max(getDayOfYear(arriveAlice), getDayOfYear(arriveBob));
            int right = Math.min(getDayOfYear(leaveAlice), getDayOfYear(leaveBob));
            return left > right ? 0 : right - left + 1;
        }

        private int getDayOfYear(String date) {
            int month = Integer.parseInt(date.split("-")[0]);
            int day = Integer.parseInt(date.split("-")[1]);
            int count = day;
            for (int i = 1; i < month; i++) {
                count += monthDays[i - 1];
            }
            return count;
        }
    }

    public static void main(String[] args) {
        String arriveAlice = "08-15", leaveAlice = "08-18", arriveBob = "08-16", leaveBob = "08-19";
        System.out.println(new Solution().countDaysTogether(arriveAlice, leaveAlice, arriveBob, leaveBob));
    }
}

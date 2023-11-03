package beijing;
/*
https://leetcode.cn/problems/number-of-valid-clock-times/
 */

/**
 * @author zhouhao
 * @date 2023/5/9 13:08
 */
// 这个简单题可不简单
public class CountTime {
    static class Solution {
        public int countTime(String time) {
            int countHour = 0;
            int countMinute = 0;
            for (int i = 0; i < 24; i++) {
                int hiHour = i / 10;
                int lowHou = i % 10;
                if ((time.charAt(0) == '?' || time.charAt(0) - '0' == hiHour) && (time.charAt(1) == '?' || time.charAt(1) - '0' == lowHou)) {
                    countHour++;
                }
            }
            for (int i = 0; i < 60; i++) {
                int hiMinute = i / 10;
                int lowMinute = i % 10;
                if ((time.charAt(3) == '?' || time.charAt(3) - '0' == hiMinute) && (time.charAt(4) == '?' || time.charAt(4) - '0' == lowMinute)) {
                    countMinute++;
                }
            }
            return countHour * countMinute;
        }
    }

    public static void main(String[] args) {
        String time = "?5:00";
        System.out.println(new Solution().countTime(time));
    }
}

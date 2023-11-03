package beijing;
/*
https://leetcode.cn/problems/determine-if-two-events-have-conflict/
 */

/**
 * @author zhouhao
 * @date 2023/5/17 12:36
 */
public class HaveConflict {
    // 简单题我居然还要看解析
    static class Solution {
        public boolean haveConflict(String[] event1, String[] event2) {
            int[] aTime = new int[]{comToInt(event1[0]), comToInt(event1[1])};
            int[] bTime = new int[]{comToInt(event2[0]), comToInt(event2[1])};
            return !(aTime[1] < bTime[0] || bTime[1] < aTime[0]);
        }

        private int comToInt(String time) {
            int hour = Integer.parseInt(time.split(":")[0]);
            int min = Integer.parseInt(time.split(":")[1]);
            return hour * 60 + min;
        }
    }

    public static void main(String[] args) {
        String[] event1 = {"10:00", "11:00"}, event2 = {"14:00", "15:00"};
        System.out.println(new Solution().haveConflict(event1, event2));
    }
}

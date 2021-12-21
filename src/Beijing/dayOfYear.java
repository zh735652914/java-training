package Beijing;

/*
https://leetcode-cn.com/problems/day-of-the-year/
 */
public class dayOfYear {
    static class Solution {
        public int dayOfYear(String date) {
            int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            String[] Dates = date.split("-");
            int Y = Integer.parseInt(Dates[0]);
            int M = Integer.parseInt(Dates[1]);
            int D = Integer.parseInt(Dates[2]);
            boolean flag = Y % 4 == 0 && Y % 100 != 0 || Y % 400 == 0;
            if (M == 1) {
                return D;
            }
            if (M == 2) {
                return months[0] + D;
            }
            int ans = D;
            for (int i = 0; i < M - 1; i++) {
                ans += months[i];
            }
            return flag ? ans + 1 : ans;
        }
    }

    public static void main(String[] args) {
        String date = "2016-02-29";
        System.out.println(new Solution().dayOfYear(date));
    }
}

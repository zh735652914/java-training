package Beijing;
/*
https://leetcode.cn/problems/minimum-number-of-moves-to-seat-everyone/
 */

import java.util.Arrays;

/**
 * @author zhouhao
 * @date 2022/12/31 11:18
 */
// 的确是很简单的一题
public class MinMovesToSeat {
    static class Solution {
        public int minMovesToSeat(int[] seats, int[] students) {
            Arrays.sort(seats);
            Arrays.sort(students);
            int count = 0;
            for (int i = 0; i < seats.length; i++) {
                count += Math.abs(students[i] - seats[i]);
            }
            return count;
        }
    }

    public static void main(String[] args) {
        int[] seats = {3, 1, 5}, students = {2, 7, 4};
        System.out.println(new Solution().minMovesToSeat(seats, students));
    }
}

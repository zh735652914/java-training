package beijing;
/*
https://leetcode.cn/problems/my-calendar-i/
 */

import java.util.TreeSet;

// 自己不会，还不太明白。大致明白了，很牛逼
public class MyCalendar {
    private final TreeSet<int[]> calendar;

    public MyCalendar() {
        calendar = new TreeSet<>((a, b) -> {
            if (a[0] >= b[1]) {
                return -1;
            } else if (a[1] <= b[0]) {
                return 1;
            } else {
                return 0;
            }
        });
    }

    public boolean book(int start, int end) {
        return calendar.add(new int[]{start, end});
    }

    public static void main(String[] args) {
        MyCalendar obj = new MyCalendar();
        int[][] nums = {{10, 20}, {15, 25}, {20, 30}};
        for (int[] num : nums) {
            System.out.println(obj.book(num[0], num[1]));
        }
    }
}

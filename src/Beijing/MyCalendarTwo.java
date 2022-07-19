package Beijing;
/*
https://leetcode.cn/problems/my-calendar-ii/
 */

import java.util.Map;
import java.util.TreeMap;

// 自己不会写，这个典型题需要看看解析！
public class MyCalendarTwo {
    TreeMap<Integer, Integer> cnt;  //  必须是TreeMap！！因为需要按顺序遍历

    public MyCalendarTwo() {
        cnt = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        cnt.put(start, cnt.getOrDefault(start, 0) + 1);
        cnt.put(end, cnt.getOrDefault(end, 0) - 1);
        int maxbooking = 0;
        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
            maxbooking += entry.getValue();
            if (maxbooking > 2) {
                cnt.put(start, cnt.getOrDefault(start, 0) - 1);
                cnt.put(end, cnt.getOrDefault(end, 0) + 1);
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MyCalendarTwo myCalendarTwo = new MyCalendarTwo();
        System.out.println(myCalendarTwo.book(10, 20)); // return True, The event can be booked.
        System.out.println(myCalendarTwo.book(50, 60)); // return True, The event can be booked.
        System.out.println(myCalendarTwo.book(10, 40)); // return True, The event can be double booked.
        System.out.println(myCalendarTwo.book(5, 15));  // return False, The event cannot be booked, because it would result in a triple booking.
        System.out.println(myCalendarTwo.book(5, 10)); // return True, The event can be booked, as it does not use time 10 which is already double booked.
        System.out.println(myCalendarTwo.book(25, 55)); // return True, The event can be booked, as the time in [25, 40) will be double booked
        // with the third event, the time [40, 50) will be single booked, and the time [50, 55) will be double booked with the second event.
    }
}

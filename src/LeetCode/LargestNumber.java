package LeetCode;
/*
179. Largest Number
Medium

1386

170

Add to List

Share
Given a list of non negative integers, arrange them such that they form the largest number.

Example 1:

Input: [10,2]
Output: "210"
Example 2:

Input: [3,30,34,5,9]
Output: "9534330"
Note: The result may be very large, so you need to return a string instead of an integer.
 */

import java.util.Arrays;
import java.util.Comparator;

//哎，智障
class LargestNumberSolution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "";
        String[] s_nums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            s_nums[i] = String.valueOf(nums[i]);
        }
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s2.compareTo(s1);
            }
        };
        Arrays.sort(s_nums, comp);
        if (s_nums[0].charAt(0) == '0') return "0";
        StringBuilder ans = new StringBuilder();
        for (String s : s_nums) {
            ans.append(s);
        }
        return ans.toString();
    }
}

//哎。。花了一下午，自己写的代码又是智障。。。

//class LargestNumberSolution {
//    public String largestNumber(int[] nums) {
//        if (nums == null) return null;
//        String[] NUM = new String[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            NUM[i] = String.valueOf(nums[i]);
//        }
//        QS(NUM, 0, NUM.length - 1);
//        StringBuilder ans = new StringBuilder();
//        for (String x : NUM) {
//            ans.append(x);
//        }
//        if (ans.charAt(0) == '0') return "0";
//        return ans.toString();
//    }
//
//
//    private void QS(String[] NUM, int left, int right) {
//        int pivot = left;
//        int index = pivot + 1;
//        for (int i = index; i <= right; i++) {
//            if (comp(NUM[i], NUM[pivot])) {
//                swap(NUM, i, index);
//                index++;
//            }
//        }
//        index--;
//        swap(NUM, pivot, index);
//
//        if (index - 1 > left) QS(NUM, left, index - 1);
//        if (index + 1 < right) QS(NUM, index + 1, right);
//    }
//
//    private void swap(String[] NUM, int i, int j) {
//        String tmp = NUM[i];
//        NUM[i] = NUM[j];
//        NUM[j] = tmp;
//    }
//
//    private boolean comp(String x, String y) {
//        if (x.length() == y.length()) {
////            System.out.println("x=" + x + " y=" + y);
////            System.out.println(Integer.parseInt(x) > Integer.parseInt(y));
//            return Integer.parseInt(x) > Integer.parseInt(y);
//        }
//        int len = Math.min(x.length(), y.length());
//        int a = Integer.parseInt(x.substring(0, len));
//        int b = Integer.parseInt(y.substring(0, len));
//        if (a == b) {
//            if (x.length() > y.length()) {
//                if ((int) x.charAt(len) > (int) y.charAt(0)) return true;
//                return false;
//            } else {
//                if ((int) x.charAt(0) >= (int) y.charAt(len)) return true;
//                return false;
//            }
//        }
//        return a > b;
//
//    }
//}

public class LargestNumber {
    public static void main(String[] args) {
//        int[] nums = {3, 30, 345, 5, 9};
//        int[] nums = {3, 0, 4, 5, 9};
//        int[] nums = {128, 12};
//        int[] nums = {121, 12};
        int[] nums = {12, 121};
//        int[] nums = {0, 0, 0, 0};
        System.out.println(new LargestNumberSolution().largestNumber(nums));
    }
}

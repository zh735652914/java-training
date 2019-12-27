package LeetCode;

import java.util.ArrayList;
import java.util.List;

/*
202. Happy Number
Easy

1254

309

Add to List

Share
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer,
replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1
(where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy numbers.

Example:

Input: 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
 */
//自己写的，效率不太高，看了discuss可以使用判断循环链表的方法去写，很妙！
class HappyNumberSolution {
    private List<Integer> SUM = new ArrayList<>();

    public boolean isHappy(int n) {
        String s = Integer.toString(n);
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int tmp = s.charAt(i) - '0';
            sum += tmp * tmp;
        }
        if (sum == 1) return true;
        if (SUM.contains(sum)) return false;
        SUM.add(sum);
        return isHappy(sum);
    }
}

public class HappyNumber {
    public static void main(String[] args) {
        int n = 19;
        System.out.println(new HappyNumberSolution().isHappy(n));
    }
}

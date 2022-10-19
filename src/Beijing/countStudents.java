package Beijing;
/*
https://leetcode.cn/problems/number-of-students-unable-to-eat-lunch/
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class countStudents {
    static class Solution {
        // 不是自己写的
        public int countStudents(int[] students, int[] sandwiches) {
            int sum1 = Arrays.stream(students).sum();
            int sum0 = students.length - sum1;
            for (int sandwich : sandwiches) {
                if (sandwich == 1 && sum1 > 0) {
                    sum1--;
                } else if (sandwich == 0 && sum0 > 0) {
                    sum0--;
                } else {
                    break;
                }
            }
            return sum0 + sum1;
        }
    }

    // 自己写的比较慢
    static class Solution0 {
        public int countStudents(int[] students, int[] sandwiches) {
            Queue<Integer> stu = new LinkedList<>();
            for (int student : students) {
                stu.offer(student);
            }
            int index = 0, stuNum = students.length, count = 0;
            while (count < stuNum && !stu.isEmpty()) {
                if (stu.peek() == sandwiches[index]) {
                    stu.poll();
                    index++;
                    stuNum = stu.size();
                    count = 0;
                } else {
                    stu.offer(stu.poll());
                    count++;
                }
            }
            return stu.size();
        }
    }

    public static void main(String[] args) {
        int[] students = {1, 1, 1, 0, 0, 1}, sandwiches = {1, 0, 0, 0, 1, 1};
        System.out.println(new Solution().countStudents(students, sandwiches));
    }
}

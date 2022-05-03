package Beijing;
/*
https://leetcode-cn.com/problems/queue-reconstruction-by-height/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 看了评论的思路自己写出来的
public class reconstructQueue {
    static class Solution {
        public int[][] reconstructQueue(int[][] people) {
            List<int[]> ans = new ArrayList<>();
            Arrays.sort(people, (o1, o2) -> {
                if (o1[1] == o2[1]) {
                    return o2[0] - o1[0];
                } else {
                    return o1[1] - o2[1];
                }
            });
            // {5, 0, } {7, 0, } {6, 1, } {7, 1, } {5, 2, } {4, 4, }
            // {7, 0, } {5, 0, } {7, 1, } {6, 1, } {5, 2, } {4, 4, }
            for (int[] person : people) {
                if (ans.isEmpty()) {
                    ans.add(person);
                    continue;
                }
                int size = ans.size();
                int count = 0;
                for (int i = 0; i <= size; i++) {
                    if (count == person[1]) {
                        ans.add(i, person);
                        break;
                    }
                    if (ans.get(i)[0] >= person[0]) {
                        count++;
                    }
                }
                if (count < person[1]) {
                    ans.add(person);
                }
            }
            int[][] result = new int[people.length][people[0].length];
            ans.toArray(result);
            return result;
        }
    }

    public static void main(String[] args) {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] ans = new Solution().reconstructQueue(people);
        for (int[] an : ans) {
            System.out.print("{");
            for (int x : an) {
                System.out.print(x + ", ");
            }
            System.out.print("} ");
        }
    }
}

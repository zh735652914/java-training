package beijing.hot100;
/*
https://leetcode.cn/problems/queue-reconstruction-by-height/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class queueReconstructionbyHeight_406 {
    // 第二次，自己还是不会写
    static class Solution {
        public int[][] reconstructQueue(int[][] people) {
            Arrays.sort(people, ((o1, o2) -> {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                } else {
                    return o1[0] - o2[0];
                }
            }));
            List<Integer> indexs = new ArrayList<>();
            for (int i = 0; i < people.length; i++) {
                indexs.add(i);
            }
            int[][] result = new int[people.length][2];
            for (int[] person : people) {
                result[indexs.get(person[1])] = person;
                indexs.remove(person[1]);
            }
            return result;
        }
    }

    public static void main(String[] args) {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] ans = new Solution().reconstructQueue(people);
        for (int[] nums : ans) {
            System.out.print("{");
            for (int num : nums) {
                System.out.print(num + ", ");
            }
            System.out.print("}, ");
        }
    }
}

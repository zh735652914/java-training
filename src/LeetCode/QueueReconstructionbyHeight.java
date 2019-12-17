package LeetCode;

import java.util.*;

/*
Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k),
where h is the height of the person and k is the number of people in front of this person who have a
height greater than or equal to h. Write an algorithm to reconstruct the queue.

Note:
The number of people is less than 1,100.


Example

Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
//自己没写出来。。。。。。不得不佩服别人的想法。。。
class QueueReconstructionbyHeightSolution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (A, B) -> A[0] == B[0] ? A[1] - B[1] : B[0] - A[0]);
        List<int[]> tmp = new LinkedList<>();
        for (int[] person : people) {
            tmp.add(person[1], person);
        }
        return tmp.toArray(new int[tmp.size()][2]);
    }
}

public class QueueReconstructionbyHeight {
    public static void main(String[] args) {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
//        int[][] people = {{1, 0}, {2, 0}};
//        int[][] people = {{2, 0}, {1, 1}};
        int[][] ans = new QueueReconstructionbyHeightSolution().reconstructQueue(people);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++) {
                System.out.print(ans[i][j] + ",");
            }
            System.out.println();
        }
    }
}

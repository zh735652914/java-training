package leetcode;
/*
378. Kth Smallest Element in a Sorted Matrix
Medium

1780

106

Add to List

Share
Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.
Note:
You may assume k is always valid, 1 ≤ k ≤ n2.
 */


import java.util.PriorityQueue;

//自己不会写，要学的东西还很多
class kthSmallestSolution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<tup> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            priorityQueue.offer(new tup(0, i, matrix[0][i]));
        }
        for (int i = 0; i < k - 1; i++) {
            tup tmp = priorityQueue.poll();
            if (tmp.x == n - 1) continue;
            priorityQueue.offer(new tup(tmp.x + 1, tmp.y, matrix[tmp.x + 1][tmp.y]));
        }
        return priorityQueue.poll().val;
    }

    class tup implements Comparable<tup> {
        int x, y, val;

        public tup(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(tup o) {
            return this.val - o.val;
        }
    }
}


public class kthSmallest {


    public static void main(String[] args) {
//        int[][] matrix = {
//                {1, 5, 9},
//                {10, 11, 13},
//                {12, 13, 15}
//        };
//        int k = 5;
//        int[][] matrix = {
//                {1, 2},
//                {1, 3}
//        };
//        int k = 3;
        int[][] matrix = {
                {-5}
        };
        int k = 1;
        System.out.println(new kthSmallestSolution().kthSmallest(matrix, k));
    }
}

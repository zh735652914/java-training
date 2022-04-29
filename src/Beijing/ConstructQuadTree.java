package Beijing;
/*
https://leetcode-cn.com/problems/construct-quad-tree/
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ConstructQuadTree {
    static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }

    // 这个递归虽然自己写出来了，但是花了很长时间，把自己递归迷糊了
    static class Solution {
        public Node construct(int[][] grid) {
            return construct(grid, 0, grid[0].length - 1, grid.length / 2);
        }

        private Node construct(int[][] grid, int x, int y, int n) {
            if (n < 1) {
                return new Node(grid[x][y] == 1, true);
            }
            Node cur = new Node();
            Node BR = construct(grid, x + n, y, n / 2);
            Node BL = construct(grid, x + n, y - n, n / 2);
            Node TL = construct(grid, x, y - n, n / 2);
            Node TR = construct(grid, x, y, n / 2);
            if (BR.isLeaf && BL.isLeaf && TL.isLeaf && TR.isLeaf) {
                if (BR.val == BL.val & BL.val == TL.val && TL.val == TR.val) {
                    cur.isLeaf = true;
                    cur.val = BL.val;
                    return cur;
                }
            }
            cur.isLeaf = false;
            cur.val = true;
            cur.topLeft = TL;
            cur.topRight = TR;
            cur.bottomLeft = BL;
            cur.bottomRight = BR;
            return cur;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0}
        };
        Node root = new Solution().construct(grid);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<List<Integer>> level = new ArrayList<>();
            while (size-- > 0) {
                Node node = queue.poll();
                if (node == null) {
                    continue;
                }
                List<Integer> aNode = new ArrayList<>();
                aNode.add(node.isLeaf ? 1 : 0);
                aNode.add(node.val ? 1 : 0);
                level.add(aNode);
                if (node.topLeft != null) {
                    queue.add(node.topLeft);
                }
                if (node.topRight != null) {
                    queue.add(node.topRight);
                }
                if (node.bottomLeft != null) {
                    queue.add(node.bottomLeft);
                }
                if (node.bottomRight != null) {
                    queue.add(node.bottomRight);
                }
            }
            System.out.println(level);
        }
    }
}

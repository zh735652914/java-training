package leetcode;

public class PerfectBinaryTreeNode {
    public int val;
    public PerfectBinaryTreeNode left;
    public PerfectBinaryTreeNode right;
    public PerfectBinaryTreeNode next;

    public PerfectBinaryTreeNode() {
    }

    public PerfectBinaryTreeNode(int _val, PerfectBinaryTreeNode _left, PerfectBinaryTreeNode _right,
                                 PerfectBinaryTreeNode _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

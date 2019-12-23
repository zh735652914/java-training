package LeetCode;

/*
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
 */
public class BuildPerfectBinaryTree {
    public PerfectBinaryTreeNode Build(int[] nums) {
        return Buildbacktrack(nums, 0);
    }

    private PerfectBinaryTreeNode Buildbacktrack(int[] nums, int pos) {
        if (pos >= nums.length) return null;
        PerfectBinaryTreeNode left = Buildbacktrack(nums, pos + pos + 1);
        PerfectBinaryTreeNode right = Buildbacktrack(nums, pos + pos + 2);
        PerfectBinaryTreeNode root = new PerfectBinaryTreeNode(nums[pos], left, right, null);
        return root;
    }
}

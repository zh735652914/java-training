package Interview;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public TreeNode buildTree(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return BDbacktrack(0, nums, 0);
    }

    private TreeNode BDbacktrack(int deep, int[] nums, int pos) {
        if (pos >= nums.length) return null;
        if (nums[pos] == Integer.MIN_VALUE) return null;
        TreeNode root = new TreeNode(nums[pos]);
        int left = (int) ((Math.pow(2, deep + 1) - 1) + 2 * (pos - (Math.pow(2, deep) - 1)));
        root.left = BDbacktrack(deep + 1, nums, left);
        root.right = BDbacktrack(deep + 1, nums, left + 1);
        return root;
    }

    private int DEEP;

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        Solution solution = new Solution();
        solution.DEEP = 0;
        TreeNode root = solution.buildTree(nums);
        solution.theDEEP(root, 0);
        System.out.println(solution.DEEP);
    }


    public void theDEEP(TreeNode root, int deep) {
        if (root == null) {
            DEEP = Math.max(deep, DEEP);
            return;
        }
        theDEEP(root.left, deep + 1);
        theDEEP(root.right, deep + 1);
    }
}

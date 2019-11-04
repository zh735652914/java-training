package LeetCode;

//java前序中序建立一颗二叉树
public class BuildTree {
    public TreeNode Build(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        if (inorder == null || inorder.length == 0) {
            return null;
        }
        int len1 = preorder.length - 1, len2 = inorder.length - 1;
        if (len1 != len2) return null;
        return dfs(preorder, inorder, 0, len2, 0);
    }

    private TreeNode dfs(int[] preorder, int[] inorder, int low, int high, int index) {
        if (low > high) return null;
        TreeNode node = new TreeNode(preorder[index]);
        if (low == high) return node;
        int pos = searchInsert(inorder, preorder[index], low, high);
        node.left = dfs(preorder, inorder, low, pos - 1, index + 1);
        node.right = dfs(preorder, inorder, pos + 1, high, index + 1 + (pos - low));
        return node;
    }

    private int searchInsert(int[] nums, int t, int low, int high) {
        int pos = 0;
        for (int i = low; i <= high; i++) {
            if (nums[i] == t) {
                pos = i;
                break;
            }
        }
        return pos;
    }
}

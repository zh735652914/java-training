package beijing;

/**
 * 滴滴二面，判断二叉树是否平衡
 *
 * @author zhouhao
 * @date 2023/5/4 19:45
 */
public class T2 {
    private static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    private static boolean isBalance(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = height(root.left);
        int right = height(root.right);
        if (Math.abs(left - right) > 1) {
            return false;
        }
        return isBalance(root.left) && isBalance(root.right);
    }
}

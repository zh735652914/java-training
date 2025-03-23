package next;

import next.utils.BuildTree;
import next.utils.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author zhouhao
 * @date 2025/3/23 11:31
 */
public class LeetCode101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSame(root.left, root.right);
    }

    private boolean isSame(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left != null && right != null) {
            if (left.val != right.val) {
                return false;
            }
            return isSame(left.left, right.right) && isSame(left.right, right.left);
        }
        return false;
    }

    @Test
    public void test() {
        String node = "[1,2,2,3,4,4,3]";
        BuildTree buildTree = new BuildTree();
        assertTrue(isSymmetric(buildTree.LevelBuildTree(node)));
    }

    @Test
    public void test2() {
        String node = "[1,2,2,null,3,null,3]";
        BuildTree buildTree = new BuildTree();
        assertFalse(isSymmetric(buildTree.LevelBuildTree(node)));
    }
}

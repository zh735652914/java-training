package next;

import next.utils.TreeNode;
import next.utils.TreeUtils;
import org.junit.Test;

/**
 * @author zhouhao
 * @date 2025/4/4 21:48
 */
public class LeetCode226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode L = invertTree(root.left);
        TreeNode R = invertTree(root.right);
        root.left = R;
        root.right = L;
        return root;
    }

    @Test
    public void test() {
        String nodes = "[4,2,7,1,3,6,9]";
        TreeNode root = TreeUtils.LevelBuildTree(nodes);
        TreeNode ans = invertTree(root);
        TreeUtils.printTree(ans);
    }
}

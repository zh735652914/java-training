package next;

import next.utils.TreeNode;
import next.utils.TreeUtils;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * @author zhouhao
 * @date 2025/4/5 10:27
 * https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class LeetCode236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode L = lowestCommonAncestor(root.left, p, q);
        TreeNode R = lowestCommonAncestor(root.right, p, q);
        if (L != null && R != null) {
            return root;
        } else if (L == null) {
            return R;
        } else {
            return L;
        }
    }

    @Test
    public void test() {
        String nodes = "[3,5,1,6,2,0,8,null,null,7,4]";
        TreeNode root = TreeUtils.LevelBuildTree(nodes);
        TreeNode q = root.left;
        TreeNode p = root.right;
        assertEquals(root, lowestCommonAncestor(root, p, q));
    }
}

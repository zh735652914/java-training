package next;

import next.utils.TreeNode;
import next.utils.TreeUtils;
import org.junit.Test;

/**
 * @author zhouhao
 * @date 2025/3/24 08:31
 * https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/
 */
public class LeetCode114 {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);
        TreeNode next = root.right;
        root.right = root.left;
        root.left = null;
        while (root.right != null) {
            root = root.right;
        }
        root.right = next;
    }

    @Test
    public void test() {
        String nodes = "[1,2,5,3,4,null,6]";
        TreeUtils treeUtils = new TreeUtils();
        TreeNode root = TreeUtils.LevelBuildTree(nodes);
        flatten(root);
        while (root.right != null) {
            System.out.print(root.val + "->");
            root = root.right;
        }
    }
}

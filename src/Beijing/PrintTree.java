package Beijing;

import java.util.LinkedList;
import java.util.Queue;

public class PrintTree {
    PrintTree() {
    }

    protected void LevelPrintTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.remove();
            PrintTreeNode(tmp);
            if (tmp == null) {
                continue;
            }
            queue.add(tmp.left);
            queue.add(tmp.right);
        }
    }

    private void PrintTreeNode(TreeNode treeNode) {
        if (treeNode == null) {
            System.out.print("null" + " ,");
        } else {
            System.out.print(treeNode.val + " ,");
        }
    }
}

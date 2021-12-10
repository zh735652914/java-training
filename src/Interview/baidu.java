package Interview;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class baidu {
    static void perOreder(TreeNode root) {
        if (root == null) {
            return;
        }
//        visit(root);
        perOreder(root.left);
        perOreder(root.right);
    }

    static void perOrder2(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;
        stack.push(cur);

        while (cur != null && !stack.isEmpty()) {
            cur = stack.pop();
//            visit(cur);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }

    }
}

package swordreferstooffer;

/*
建立二叉树，不一定正确；
未测试
 */

import java.util.Arrays;

public class BuildTreeNode {
    public TreeNode build(int[] pre, int[] mid) {
        if (pre.length == 0 || mid.length == 0) return null;
        TreeNode root = new TreeNode(pre[0]);
        int pos = 0;
        while (pos < mid.length) {
            if (pre[0] == mid[pos]) break;
            pos++;
        }
        if (pos == mid.length) {
            System.out.println("建树失败！");
            return null;
        }
        if (pos != 0) {
            root.left = build(pre, Arrays.copyOfRange(mid, 0, pos));
        } else {
            root.left = null;
        }
        if (pos != mid.length - 1) {
            root.right = build(pre, Arrays.copyOfRange(mid, pos + 1, mid.length));
        } else {
            root.right = null;
        }
        return root;
    }
}

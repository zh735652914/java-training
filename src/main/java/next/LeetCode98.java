package next;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author zhouhao
 * @date 2025/3/22 10:40
 * https://leetcode.cn/problems/validate-binary-search-tree/
 */
public class LeetCode98 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    long preVal = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left) || root.val <= preVal) {
            return false;
        }
        preVal = root.val;
        return isValidBST(root.right);
    }


    @Test
    public void test1() {
        String s = "[5,1,4,null,null,3,6]";
        TreeNode root = LevelBuildTree(s);
        System.out.println(isValidBST(root));
        assertFalse(isValidBST(root));
    }

    @Test
    public void test2() {
        String s = "[2,1,3]";
        TreeNode root = LevelBuildTree(s);
//        System.out.println(isValidBST(root));
        assertTrue(isValidBST(root));
    }

    @Test
    public void test3() {
        String s = "[1,1]";
        TreeNode root = LevelBuildTree(s);
        System.out.println(isValidBST(root));
        assertFalse(isValidBST(root));
    }

    @Test
    public void test4() {
        String s = "[5,4,6,null,null,3,7]";
        TreeNode root = LevelBuildTree(s);
//        System.out.println(isValidBST(root));
        assertFalse(isValidBST(root));
    }


    public TreeNode LevelBuildTree(String s) {
        s = s.substring(1, s.length() - 1);
        String[] nodes = s.split(",");
        return LevelBuildTree(nodes);
    }

    public TreeNode LevelBuildTree(String[] s) {
        TreeNode[] nodes = new TreeNode[s.length];
        for (int i = 0; i < nodes.length; i++) {
            if (s[i].equals("null") || s[i].equals("NULL")) {
                continue;
            }
            nodes[i] = new TreeNode(Integer.parseInt(s[i]));
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        LevelBacktrack(nodes, queue, 1);
        return nodes[0];
    }

    private void LevelBacktrack(TreeNode[] nodes, Queue<Integer> Q, int index) {
        int n = Q.size();
        if (n == 0 || index >= nodes.length) {
            return;
        }
        while (n > 0) {
            if (index >= nodes.length) {
                break;
            }
            TreeNode root = nodes[Q.remove()];
            if (nodes[index] != null) {
                root.left = nodes[index];
                Q.add(index);
            }
            index++;
            if (index >= nodes.length) {
                break;
            }
            if (nodes[index] != null) {
                root.right = nodes[index];
                Q.add(index);
            }
            index++;
            n--;
        }
        LevelBacktrack(nodes, Q, index);
    }
}

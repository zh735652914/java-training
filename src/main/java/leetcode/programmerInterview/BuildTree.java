package leetcode.programmerInterview;

import java.util.LinkedList;
import java.util.Queue;

public class BuildTree {
    public TreeNode level_build_tree(String[] nums) {
        TreeNode[] nodes = new TreeNode[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i].equals("null")) continue;
            nodes[i] = new TreeNode(Integer.parseInt(nums[i]));
        }
        Queue<Integer> Q = new LinkedList<>();
        Q.add(0);
        LevelBacktrack2(nodes, Q, 1);
        return nodes[0];
    }

    private void LevelBacktrack2(TreeNode[] nodes, Queue<Integer> Q, int index) {
        int n = Q.size();
        if (n == 0 || index >= nodes.length) return;
        while (n > 0) {
            if (index >= nodes.length) break;
            TreeNode root = nodes[Q.remove()];
            if (nodes[index] != null) {
                root.left = nodes[index];
                Q.add(index);
            }
            index++;
            if (index >= nodes.length) break;
            if (nodes[index] != null) {
                root.right = nodes[index];
                Q.add(index);
            }
            index++;
            n--;
        }
        LevelBacktrack2(nodes, Q, index);
    }
}

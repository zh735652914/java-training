package beijing;

import java.util.LinkedList;
import java.util.Queue;

public class BuildTree {
    public BuildTree() {

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

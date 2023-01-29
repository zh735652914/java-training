package beijing;

import java.util.LinkedList;
import java.util.List;

// 效率太低了
public class BSTIterator {
    private final List<Integer> nodes;
    private int index;

    public BSTIterator(TreeNode root) {
        /*
        if(null) return;
        left();
        root;
        right();
         */
        nodes = new LinkedList<>();
        inOrder(root);
        index = 0;
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        nodes.add(root.val);
        inOrder(root.right);
    }

    public int next() {
        return nodes.get(index++);
    }

    public boolean hasNext() {
        return index < nodes.size();
    }

    public static void main(String[] args) {
        String[] ops = {"BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"};
        String[] nodes = {"7", "3", "15", "null", "null", "9", "20"};
        TreeNode root = new BuildTree().LevelBuildTree(nodes);
        BSTIterator bSTIterator = new BSTIterator(root);
        for (int i = 1; i < ops.length; i++) {
            switch (ops[i]) {
                case "next":
                    System.out.println(bSTIterator.next());
                    break;
                case "hasNext":
                    System.out.println(bSTIterator.hasNext());
                    break;
            }
        }
    }
}

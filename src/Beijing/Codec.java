package Beijing;
/*
https://leetcode.cn/problems/serialize-and-deserialize-bst/
 */

/*
搜索二叉树中序遍历有序，
只需要先序或者中序可以建立一棵搜索二叉树
 */
public class Codec {

    private StringBuilder stringBuilder;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        stringBuilder = new StringBuilder();
        preOrder(root);
        if (stringBuilder.length() == 0) {
            return stringBuilder.toString();
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    private void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        stringBuilder.append(root.val);
        stringBuilder.append(",");
        preOrder(root.left);
        preOrder(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() < 1) {
            return null;
        }
        String[] nodes = data.split(",");
        return buildTree(nodes, 0, nodes.length - 1);
    }

    private TreeNode buildTree(String[] nodes, int start, int end) {
        if (start > end) {
            return null;
        }
        int val = Integer.parseInt(nodes[start]);
        TreeNode root = new TreeNode(val);
        if (end == start) {
            return root;
        }
        int mid = start + 1;
        while (mid <= end && Integer.parseInt(nodes[mid]) < val) {
            mid++;
        }
        root.left = buildTree(nodes, start + 1, mid - 1);
        root.right = buildTree(nodes, mid, end);
        return root;
    }


    public static void main(String[] args) {
        String[] nodes = {"2", "1", "3"};
        // Input: root = [2,1]
        TreeNode root = new BuildTree().LevelBuildTree(nodes);
//        String input = "2,1";
        Codec ser = new Codec();
//        TreeNode root = ser.deserialize(input);
        String data = ser.serialize(root);
        System.out.println(data);
        new PrintTree().LevelPrintTree(ser.deserialize(data));
    }
}

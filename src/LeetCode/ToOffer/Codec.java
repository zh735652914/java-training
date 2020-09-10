package LeetCode.ToOffer;
/*
剑指 Offer 37. 序列化二叉树
请实现两个函数，分别用来序列化和反序列化二叉树。

示例:

你可以将以下二叉树：

    1
   / \
  2   3
     / \
    4   5

序列化为 "[1,2,3,null,null,4,5]"
注意：本题与主站 297 题相同：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/

通过次数20,294提交次数38,572
 */


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> list = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            list.add(makeString(tmp));
            if (tmp != null) {
                queue.offer(tmp.left);
                queue.offer(tmp.right);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (String s : list) {
            stringBuilder.append(s);
            stringBuilder.append(",");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }


    private String makeString(TreeNode root) {
        if (root == null) {
            return "null";
        } else {
            return String.valueOf(root.val);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.substring(1, data.length() - 1).split(",");
        if (nodes.length == 0 || nodes[0].equals("null")) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        queue.offer(root);
        int index = 1;
        while (index < nodes.length && !queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            tmp.left = make_node(nodes, index++);
            tmp.right = make_node(nodes, index++);
            if (tmp.left != null) {
                queue.offer(tmp.left);
            }
            if (tmp.right != null) {
                queue.offer(tmp.right);
            }
        }
        return root;
    }

    private TreeNode make_node(String[] nodes, int index) {
        TreeNode node = null;
        if (index < nodes.length && !nodes[index].equals("null")) {
            node = new TreeNode(Integer.parseInt(nodes[index]));
        }
        return node;
    }


    public static void main(String[] args) {
        String data = "[1,2,3,null,null,4,5]";
        Codec codec = new Codec();
        TreeNode root = codec.deserialize(data);
        System.out.println(codec.serialize(root));
    }
}
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
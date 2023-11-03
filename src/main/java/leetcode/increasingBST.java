package leetcode;
/*
897. 递增顺序查找树
给你一个树，请你 按中序遍历 重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。



示例 ：

输入：[5,3,6,2,4,null,8,1,null,null,null,7,9]

       5
      / \
    3    6
   / \    \
  2   4    8
 /        / \
1        7   9

输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]

 1
  \
   2
    \
     3
      \
       4
        \
         5
          \
           6
            \
             7
              \
               8
                \
                 9


提示：

给定树中的结点数介于 1 和 100 之间。
每个结点都有一个从 0 到 1000 范围内的唯一整数值。
通过次数15,181提交次数21,082
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class increasingBST {

    static class Solution {
        TreeNode perhead = new TreeNode(-1);
        TreeNode curr = perhead;

        public TreeNode increasingBST(TreeNode root) {
            if (root == null) {
                return null;
            }
            increasingBST(root.left);
            curr.right = root;
            curr = curr.right;
            curr.left = null;
            increasingBST(curr.right);
            return perhead.right;
        }
    }

    static class buildTree {
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
    }

    static class outputTree {
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
    }

    public static void main(String[] args) {
        String node = "[5,3,6,2,4,null,8,1,null,null,null,7,9]";
        TreeNode root = new buildTree().deserialize(node);
        TreeNode after = new Solution().increasingBST(root);
        System.out.println(new outputTree().serialize(after));
    }
}

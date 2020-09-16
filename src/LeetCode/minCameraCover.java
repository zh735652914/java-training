package LeetCode;
/*
968. 监控二叉树
给定一个二叉树，我们在树的节点上安装摄像头。

节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。

计算监控树的所有节点所需的最小摄像头数量。



示例 1：



输入：[0,0,null,0,0]
输出：1
解释：如图所示，一台摄像头足以监控所有节点。
示例 2：



输入：[0,0,null,0,null,0,null,null,0]
输出：2
解释：需要至少两个摄像头来监视树的所有节点。 上图显示了摄像头放置的有效位置之一。

提示：

给定树的节点数的范围是 [1, 1000]。
每个节点的值都是 0。
通过次数3,623提交次数9,027
 */

import java.util.LinkedList;
import java.util.Queue;

public class minCameraCover {
    static class Solution {
        private int count;

        public int minCameraCover(TreeNode root) {
            if (root == null) {
                return 0;
            }
            count = 0;
            if (dfs(root) == 1) {
                count++;
            }
            return count;
        }

        private int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = dfs(root.left);
            int right = dfs(root.right);
            if (left == 1 || right == 1) {
                count++;
                return 2;
            } else if (left == 2 || right == 2) {
                return 0;
            } else {
                return 1;
            }
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

    public static void main(String[] args) {
        String nodes = "[0,0,null,0,null,0,null,null,0]";
        TreeNode root = new buildTree().deserialize(nodes);
        System.out.println(new Solution().minCameraCover(root));
    }
}

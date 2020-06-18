package LeetCode.ProgrammerInterview;
/*
面试题 04.08. 首个共同祖先
设计并实现一个算法，找出二叉树中某两个节点的第一个共同祖先。不得将其他的节点存储在另外的数据结构中。注意：这不一定是二叉搜索树。

例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4]

    3
   / \
  5   1
 / \ / \
6  2 0  8
  / \
 7   4
示例 1:
输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
输入: 3
解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
示例 2:
输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
输出: 5
解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
说明:
所有节点的值都是唯一的。
p、q 为不同节点且均存在于给定的二叉树中。
通过次数2,708提交次数3,943
 */

//第三遍写了。。。。结果还是不会
public class lowestCommonAncestor {
    static class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (p == root || q == root || root == null) return root;
            TreeNode Left = lowestCommonAncestor(root.left, p, q);
            TreeNode Right = lowestCommonAncestor(root.right, p, q);
            if (Left != null && Right != null) return root;
            return Left != null ? Left : Right;
        }
    }

    TreeNode p, q;

    public static void main(String[] args) {
        String[] nodes = {"3", "5", "1", "6", "2", "0", "8", "null", "null", "7", "4"};
        TreeNode root = new BuildTree().level_build_tree(nodes);
        int p_val = 5, q_val = 1;
        lowestCommonAncestor obj = new lowestCommonAncestor();
        obj.find_nodes(root, p_val, q_val);
        System.out.println(new Solution().lowestCommonAncestor(root, obj.p, obj.q).val);
    }

    private void find_nodes(TreeNode root, int p_val, int q_val) {
        if (root == null) return;
        if (root.val == p_val) {
            p = root;
        }
        if (root.val == q_val) {
            q = root;
        }
        find_nodes(root.left, p_val, q_val);
        find_nodes(root.right, p_val, q_val);
    }
}

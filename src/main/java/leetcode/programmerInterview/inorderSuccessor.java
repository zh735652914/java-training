package leetcode.programmerInterview;
/*
面试题 04.06. 后继者
设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。

如果指定节点没有对应的“下一个”节点，则返回null。

示例 1:

输入: root = [2,1,3], p = 1

  2
 / \
1   3

输出: 2
示例 2:

输入: root = [5,3,6,2,4,null,null,1], p = 6

      5
     / \
    3   6
   / \
  2   4
 /
1

输出: null
通过次数3,611提交次数6,360
 */

//这么简单的一道题，我却没写出来。。。
public class inorderSuccessor {
    static class Solution {
        TreeNode ans;
        Boolean flag = false;

        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            if (root == null) return ans;
            inorderSuccessor(root.left, p);
            if (root == p) {
                flag = true;
            } else if (flag) {
                ans = root;
                flag = false;
            }
            inorderSuccessor(root.right, p);
            return ans;
        }
    }

    TreeNode target;

    public static void main(String[] args) {
//        String[] nodes = {"5", "3", "6", "2", "4", "null", "null", "1"};
        String[] nodes = {"2", "1", "3"};
        TreeNode root = new BuildTree().level_build_tree(nodes);
        int p_val = 1;
        inorderSuccessor obj = new inorderSuccessor();
        obj.InOrderVisit(root, p_val);
        TreeNode ans = new Solution().inorderSuccessor(root, obj.target);
        if (ans == null) {
            System.out.println("null");
        } else {
            System.out.println(ans.val);
        }
    }

    private void InOrderVisit(TreeNode root, int p_val) {
        if (root == null) return;
        InOrderVisit(root.left, p_val);
        if (root.val == p_val) {
            target = root;
        }
        InOrderVisit(root.right, p_val);
    }
}

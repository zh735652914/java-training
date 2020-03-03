package LeetCode.ToOffer;
/*
面试题26. 树的子结构
输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)

B是A的子结构， 即 A中有出现和B相同的结构和节点值。

例如:
给定的树 A:

     3
    / \
   4   5
  / \
 1   2
给定的树 B：

   4
  /
 1
返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。

示例 1：

输入：A = [1,2,3], B = [3,1]
输出：false
示例 2：

输入：A = [3,4,5,1,2], B = [4,1]
输出：true
限制：

0 <= 节点个数 <= 10000

通过次数2,886提交次数6,348
 */

import java.util.Scanner;

public class isSubStructure {
    static class Solution {
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            if (A == null) return B == null;
            if (B == null) return false;
            if (B.left == null && B.right == null) {
                return A.val == B.val || isSubStructure(A.left, B) || isSubStructure(A.right, B);
            }
            if (A.val == B.val) {
                if (B.left != null && B.right != null) {
                    return child(A, B) && isSubStructure(A.left, B.left) && isSubStructure(A.right, B.right);
                } else if (B.right == null) {
                    return child(A, B) && isSubStructure(A.left, B.left);
                } else {
                    return child(A, B) && isSubStructure(A.right, B.right);
                }
                //若去掉注释则出现错误
//                return child(A, B) &&
//                        (isSubStructure(A.left, B.left) && isSubStructure(A.right, B.right) || isSubStructure(A.left, B.left) || isSubStructure(A.right, B.right));

            } else {
                return isSubStructure(A.left, B) || isSubStructure(A.right, B);
            }
        }

        private boolean child(TreeNode A, TreeNode B) {
            if (A.val != B.val) return false;
            if (B.left != null && B.right != null) {
                if (A.left == null || A.right == null) return false;
                return A.left.val == B.left.val && A.right.val == B.right.val;
            } else if (B.left == null && B.right == null) {
                return A.left == null && A.right == null;
            } else if (B.left != null) {
                if (A.left == null) return false;
                return A.left.val == B.left.val;
            } else {
                if (A.right == null) return false;
                return A.right.val == B.right.val;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        isSubStructure isSubStructure = new isSubStructure();
        int[] nums1 = isSubStructure.INPUT(scanner.nextLine().split(","));
        int[] nums2 = isSubStructure.INPUT(scanner.nextLine().split(","));
        buildTree.levelBuild buildTree = new buildTree.levelBuild();
        TreeNode root1 = buildTree.buildTree(nums1);
        TreeNode root2 = buildTree.buildTree(nums2);
        System.out.println(new Solution().isSubStructure(root1, root2));
    }

    private int[] INPUT(String[] Arr) {
        int[] nums = new int[Arr.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(Arr[i]);
        }
        return nums;
    }
}

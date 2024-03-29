package leetcode.tooffer;
/*
面试题07. 重建二叉树
输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。



例如，给出

前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7


限制：

0 <= 节点个数 <= 5000
 */


import java.util.Scanner;

public class buildTree {
    static class levelBuild {
//        @Test
//        public void test() {
//            Scanner scanner = new Scanner(System.in);
//            String[] Arr = scanner.nextLine().split(",");
//            int[] nums = new int[Arr.length];
//            for (int i = 0; i < nums.length; i++) {
//                nums[i] = Integer.parseInt(Arr[i]);
//            }
//            buildTree(nums);
//        }

        public TreeNode buildTree(int[] nums) {
            if (nums == null || nums.length == 0) return null;
            return backtrack(0, nums, 0);
        }

        public TreeNode buildTree(String[] nodes) {
            if (nodes == null || nodes.length == 0) return null;
            int[] nums = new int[nodes.length];
            for (int i = 0; i < nums.length; i++) {
                if (nodes[i].equals("null")) {
                    nums[i] = Integer.MIN_VALUE;
                } else {
                    nums[i] = Integer.parseInt(nodes[i]);
                }
            }
            return backtrack(0, nums, 0);
        }

        private TreeNode backtrack(int deep, int[] nums, int pos) {
            if (pos >= nums.length) return null;
            if (nums[pos] == Integer.MIN_VALUE) return null;
            TreeNode root = new TreeNode(nums[pos]);
            int left = (int) ((Math.pow(2, deep + 1) - 1) + 2 * (pos - (Math.pow(2, deep) - 1)));
            root.left = backtrack(deep + 1, nums, left);
            root.right = backtrack(deep + 1, nums, left + 1);
            return root;
        }
    }

    //前序中序建树
    static class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) throws Exception {
            if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) return null;
            if (preorder.length != inorder.length) {
                throw new Exception("无法建立一棵树！");
            }
            return dfs(preorder, inorder, 0, preorder.length - 1, 0);
        }

        private TreeNode dfs(int[] preorder, int[] inorder, int start, int end, int index) throws Exception {
            if (start > end) return null;
            TreeNode node = new TreeNode(preorder[index]);
            if (start == end) return node;
            int pos = searchPOS(inorder, preorder[index], start, end);
            node.left = dfs(preorder, inorder, start, pos - 1, index + 1);
            node.right = dfs(preorder, inorder, pos + 1, end, index + 1 + (pos - start));
            return node;
        }

        private int searchPOS(int[] inorder, int x, int start, int end) throws Exception {
            int pos = -1;
            for (int i = start; i <= end; i++) {
                if (inorder[i] == x) {
                    pos = i;
                    break;
                }
            }
            if (pos == -1) {
                throw new Exception("无法建立一棵树！");
            }
            return pos;

        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("preorder=:");
        int[] preorder = toINTarr(scanner.nextLine().split(","));
        System.out.println("inorder=:");
        int[] inorder = toINTarr(scanner.nextLine().split(","));

//        int[] preorder = {3, 9, 20, 15, 7};
//        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode root = new Solution().buildTree(preorder, inorder);
        new travelTree().levelTree(root);
    }

    private static int[] toINTarr(String[] Arr) {
        int[] nums = new int[Arr.length];
        for (int i = 0; i < Arr.length; i++) {
            nums[i] = Integer.parseInt(Arr[i]);
        }
        return nums;
    }
}

package interview;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class jinshan_bishi0 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void solution(TreeNode root) {
        if (root == null) {
            System.out.println("No");
        }
        if (hasBalance(root)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private boolean hasBalance(TreeNode root) {
        if (root.left == null || root.right == null) {
            return false;
        }
        int L = findSum(root.left, 0);
        int R = findSum(root.right, 0);
        if (L == R) {
            return true;
        }
        return hasBalance(root.left) || hasBalance(root.right);
    }

    private int findSum(TreeNode root, int sum) {
        if (root == null) {
            return sum;
        }
        sum += root.val;
        int L = 0, R = 0;
        if (root.left != null) {
            L = findSum(root.left, 0);
        }
        if (root.right != null) {
            R = findSum(root.right, 0);
        }
        return sum + L + R;
    }

    static class buildTree {
        public TreeNode buildtree(String s) {
            String[] nodes = s.split(" ");
            if (nodes.length == 0) {
                return null;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            TreeNode root = mkNode(nodes[0]);
            queue.offer(root);
            TreeNode p;
            int index = 1;
            while (!queue.isEmpty()) {
                p = queue.poll();
                if (index < nodes.length) {
                    p.left = mkNode(nodes[index++]);
                }
                if (index < nodes.length) {
                    p.right = mkNode(nodes[index++]);
                }
                if (p.left != null) {
                    queue.offer(p.left);
                }
                if (p.right != null) {
                    queue.offer(p.right);
                }
            }
            return root;
        }

        private TreeNode mkNode(String x) {
            if (x.equals("null")) {
                return null;
            }
            return new TreeNode(Integer.parseInt(x));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        while (n-- > 0) {
            String nodes = scanner.nextLine();
            TreeNode root = new buildTree().buildtree(nodes);
            new jinshan_bishi0().solution(root);
        }
    }
}

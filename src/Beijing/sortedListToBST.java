package Beijing;
/*
https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/
 */

public class sortedListToBST {
    static class Solution {
        public TreeNode sortedListToBST(ListNode head) {
            int len = 0;
            ListNode p = head;
            while (p != null) {
                len++;
                p = p.next;
            }
            TreeNode root = ToBST(head, len);
            return root;
        }

        private TreeNode ToBST(ListNode head, int len) {
            if (len == 0) {
                return null;
            }
            if (len < 2) {
                return new TreeNode(head.val);
            }
            TreeNode root = null;
            if (len == 2) {
                root = new TreeNode(head.val);
                root.right = new TreeNode(head.next.val);
            } else {
                int mid = (len + 1) / 2;
                ListNode pos = head;
                for (int i = 1; i < mid; i++) {
                    pos = pos.next;
                }
                root = new TreeNode(pos.val);
                root.left = ToBST(head, mid - 1);
                root.right = ToBST(pos.next, len - mid);
            }
            return root;
        }
    }

    public static void main(String[] args) {
        int[] nodes = {-10, -3, 0, 5, 9};
        ListNode preHead = new ListNode(-1);
        ListNode p = preHead;
        for (int node : nodes) {
            p.next = new ListNode(node);
            p = p.next;
        }
        TreeNode root = new Solution().sortedListToBST(preHead.next);
        new PrintTree().LevelPrintTree(root);
    }
}

package LeetCode;

/*
Share
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted linked list: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
 */
//不会。。。自己写都没有思路
//别人的思路很厉害！！！
class ConvertSortedListtoBinarySearchTreeSolution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return backtrack(head, null);
    }

    private TreeNode backtrack(ListNode head, ListNode tail) {
        if (head == tail) return null;
        ListNode fast = head, slow = head;
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = backtrack(head, slow);
        root.right = backtrack(slow.next, tail);
        return root;
    }
}

public class ConvertSortedListtoBinarySearchTree {
    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        BuildLinkedList buildLinkedList = new BuildLinkedList();
        ListNode head = buildLinkedList.Build(nums);
        ConvertSortedListtoBinarySearchTreeSolution SO = new ConvertSortedListtoBinarySearchTreeSolution();
        BinaryTreeLevelOrderTraversalSolution binaryTreeLevelOrderTraversalSolution = new BinaryTreeLevelOrderTraversalSolution();
        System.out.println(binaryTreeLevelOrderTraversalSolution.levelOrder(SO.sortedListToBST(head)));
    }
}

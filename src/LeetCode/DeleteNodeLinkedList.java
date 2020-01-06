package LeetCode;
/*
237. Delete Node in a Linked List
Easy

1039

5045

Add to List

Share
Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

Given linked list -- head = [4,5,1,9], which looks like following:





Example 1:

Input: head = [4,5,1,9], node = 5
Output: [4,1,9]
Explanation: You are given the second node with value 5,
the linked list should become 4 -> 1 -> 9 after calling your function.
Example 2:

Input: head = [4,5,1,9], node = 1
Output: [4,5,9]
Explanation: You are given the third node with value 1,
the linked list should become 4 -> 5 -> 9 after calling your function.


Note:

The linked list will have at least two elements.
All of the nodes' values will be unique.
The given node will not be the tail and it will always be a valid node of the linked list.
Do not return anything from your function.
 */


class DeleteNodeLinkedListSolution {
    private ListNode head = null;


    public void deleteNode(ListNode node) {
        if (node != null && node.next != null) {
            node.val = node.next.val;
            node.next = node.next.next;
        }

        test(head);
    }

    //一开始没有理解题目的意思。。。
    public void deleteNode0(ListNode node) {
        ListNode faster = head.next;
        ListNode slow = head;
        while (faster != null) {
            if (faster.val == node.val || faster == node) {
                slow.next = faster.next;
                break;
            }
            faster = faster.next;
            slow = slow.next;
        }

        test(head);
    }

    public void setHead(ListNode head, ListNode node) {
        this.head = head;
        deleteNode(node);
    }

    private void test(ListNode head) {
        ListNode p = head;
        while (p != null) {
            System.out.print(p.val + "->");
            p = p.next;
        }
    }
}

public class DeleteNodeLinkedList {
    public static void main(String[] args) {
        int[] nums = {4, 5, 1, 9};
        int nodeval = 1;
        ListNode head = null, p = null, node = null;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                head = new ListNode(nums[i]);
                p = head;
            } else {
                p.next = new ListNode(nums[i]);
                p = p.next;
                if (nums[i] == nodeval) {
                    node = p;
                }
            }
        }
//        ListNode node = new ListNode(nodeval);
        DeleteNodeLinkedListSolution deleteNodeLinkedListSolution = new DeleteNodeLinkedListSolution();
        deleteNodeLinkedListSolution.setHead(head, node);
    }
}

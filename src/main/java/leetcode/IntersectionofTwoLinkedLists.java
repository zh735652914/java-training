package leetcode;
/*
Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:


begin to intersect at node c1.



Example 1:


Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
Output: Reference of the node with value = 8
Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,0,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.


Example 2:


Input: intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
Output: Reference of the node with value = 2
Input Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [0,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.


Example 3:


Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
Output: null
Input Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
Explanation: The two lists do not intersect, so return null.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
 */

import java.util.Stack;

class IntersectionofTwoLinkedListsSolution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Stack<ListNode> A = new Stack<>();
        Stack<ListNode> B = new Stack<>();
        ListNode p = headA, q = headB;
        while (p != null) {
            A.push(p);
            p = p.next;
        }
        while (q != null) {
            B.push(q);
            q = q.next;
        }
        ListNode intersection = null;
        while (!A.empty() && !B.empty()) {
            p = A.pop();
            q = B.pop();
            if (p != q) {
                intersection = p.next;
                break;
            }
        }
        if (A.empty() && B.empty() && (headA == headB)) {
            intersection = headA;
        }
        if (p == q) {
            intersection = p;
        }
        return intersection;
    }
}

public class IntersectionofTwoLinkedLists {
    public static void main(String[] args) {
//        int[] numsA = {4, 1, 8, 4, 5};
//        int[] numsB = {5, 0, 1, 8, 4, 5};
//        int intersectVal = 8, skipA = 2, skipB = 3;
//        int[] numsA = {1};
//        int[] numsB = {1};
//        int intersectVal = 1, skipA = 0, skipB = 0;
        int[] numsA = {3};
        int[] numsB = {2, 3};
        int intersectVal = 3, skipA = 0, skipB = 1;
        ListNode intersection = new ListNode(intersectVal);
        ListNode perheadA = new ListNode(-1);
        ListNode perheadB = new ListNode(-1);
        ListNode p = perheadA;
        for (int i = 0; i < skipA; i++) {
            p.next = new ListNode(numsA[i]);
            p = p.next;
        }
        ListNode q = perheadB;
        for (int i = 0; i < skipB; i++) {
            q.next = new ListNode(numsB[i]);
            q = q.next;
        }
        p.next = intersection;
        q.next = intersection;
        ListNode pos = intersection;
        for (int i = skipA + 1; i < numsA.length; i++) {
            pos.next = new ListNode(numsA[i]);
            pos = pos.next;
        }
        IntersectionofTwoLinkedListsSolution intersectionofTwoLinkedListsSolution = new IntersectionofTwoLinkedListsSolution();
        System.out.println(intersectionofTwoLinkedListsSolution.getIntersectionNode(perheadA.next, perheadB.next));
        System.out.println(intersectionofTwoLinkedListsSolution.getIntersectionNode(perheadA.next, perheadB.next).val);
    }
}

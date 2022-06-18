package Beijing;
/*
https://leetcode.cn/problems/4ueAj6/
 */

// 这题有点变态
public class OfferII029 {
    // Definition for a Node.
    static class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }

    static class Solution {
        public Node insert(Node head, int insertVal) {
            Node node = new Node(insertVal);
            if (head == null) {
                node.next = node;
                return node;
            }
            if (head.next == head) {
                head.next = node;
                node.next = head;
                return head;
            }
            Node cur = head, next = head.next;
            while (next != head) {
                if (next.val >= insertVal && cur.val <= insertVal) {
                    break;
                }
                if (next.val < cur.val) {
                    if (insertVal < next.val || insertVal > cur.val) {
                        break;
                    }
                }
                cur = cur.next;
                next = next.next;
            }
            cur.next = node;
            node.next = next;
            return head;
        }
    }

    public static void main(String[] args) {
        int[] nodes = {1, 1, 1};
        int insertVal = 0;
        Node dummyHead = new Node(-1);
        Node p = dummyHead;
        for (int node : nodes) {
            p.next = new Node(node);
            p = p.next;
        }
        p.next = dummyHead.next;
//        dummyHead.next = null;
        Node head = new Solution().insert(dummyHead.next, insertVal);
        p = head.next;
        System.out.print(head.val + "->");
        while (p != head) {
            System.out.print(p.val + "->");
            p = p.next;
        }
    }
}

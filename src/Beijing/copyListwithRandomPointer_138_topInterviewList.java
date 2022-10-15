package Beijing;
/*
https://leetcode.cn/problems/copy-list-with-random-pointer/
 */

import java.util.HashMap;
import java.util.Map;

public class copyListwithRandomPointer_138_topInterviewList {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    // 有点忘记怎么写了
    static class Solution {
        public Node copyRandomList(Node head) {
            Map<Node, Node> map = new HashMap<>(); //<旧node，新node>
            Node p = head;
            Node newDummyHead = new Node(-1);
            Node q = newDummyHead;
            while (p != null) {
                q.next = new Node(p.val);
                map.put(p, q.next);
                p = p.next;
                q = q.next;
            }
            p = head;
            q = newDummyHead.next;
            while (p != null) {
                if (p.random != null) {
                    q.random = map.get(p.random);
                }
                p = p.next;
                q = q.next;
            }
            return newDummyHead.next;
        }
    }

    // 之前写的mian中建立链表有问题
    public static void main(String[] args) {
        String[][] nodes = {{"7", "null"}, {"13", "0"}, {"11", "4"}, {"10", "2"}, {"1", "0"}};
        Node dummyHead = new Node(-1);
        Node p = dummyHead;
        Map<Integer, Node> map = new HashMap<>();
        for (int i = 0; i < nodes.length; i++) {
            p.next = new Node(Integer.parseInt(nodes[i][0]));
            map.put(i, p.next);
            p = p.next;
        }
        p = dummyHead.next;
        for (String[] node : nodes) {
            p.random = node[1].equals("null") ? null : map.get(Integer.parseInt(node[1]));
            p = p.next;
        }
        Node ans = new Solution().copyRandomList(dummyHead.next);
        while (ans != null) {
            System.out.print("{");
            if (ans.random != null) {
                System.out.print(ans.val + ", " + ans.random.val);
            } else {
                System.out.print(ans.val + ", null");
            }
            System.out.print("}, ");
            ans = ans.next;
        }
    }
}

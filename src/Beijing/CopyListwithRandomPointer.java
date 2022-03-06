package Beijing;
/*
https://leetcode-cn.com/problems/copy-list-with-random-pointer/
 */

import java.util.HashMap;
import java.util.Map;

public class CopyListwithRandomPointer {
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

    static class Solution {
        public Node copyRandomList(Node head) {
            Node dummyHead = new Node(-1);
            Node p = dummyHead, q = head;
            Map<Node, Node> map = new HashMap<>();
            while (q != null) {
                if (map.containsKey(q)) {
                    p.next = map.get(q);
                } else {
                    p.next = new Node(q.val);
                    map.put(q, p.next);
                }
                if (q.random != null) {
                    if (!map.containsKey(q.random)) {
                        map.put(q.random, new Node(q.random.val));
                    }
                    p.next.random = map.get(q.random);
                }
                p = p.next;
                q = q.next;
            }
            return dummyHead.next;
        }
    }

    public static void main(String[] args) {
        String[][] nodes = {{"7", "null"}, {"13", "0"}, {"11", "4"}, {"10", "2"}, {"1", "0"}};
        Node dummyHead = new Node(-1);
        Node p = dummyHead;
        Map<Integer, Node> map = new HashMap<>();
        for (String[] node : nodes) {
            p.next = new Node(Integer.parseInt(node[0]));
            map.put(Integer.parseInt(node[0]), p.next);
            if (!node[1].equals("null")) {
                int Rvalue = Integer.parseInt(node[1]);
                if (!map.containsKey(Rvalue)) {
                    map.put(Rvalue, new Node(Rvalue));
                }
                p.next.random = map.get(Rvalue);
            }
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

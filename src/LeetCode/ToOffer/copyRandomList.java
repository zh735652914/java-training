package LeetCode.ToOffer;
/*
面试题35. 复杂链表的复制
请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。



示例 1：



输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
示例 2：



输入：head = [[1,1],[2,1]]
输出：[[1,1],[2,1]]
示例 3：



输入：head = [[3,null],[3,0],[3,null]]
输出：[[3,null],[3,0],[3,null]]
示例 4：

输入：head = []
输出：[]
解释：给定的链表为空（空指针），因此返回 null。


提示：

-10000 <= Node.val <= 10000
Node.random 为空（null）或指向链表中的节点。
节点数目不超过 1000 。


注意：本题与主站 138 题相同：https://leetcode-cn.com/problems/copy-list-with-random-pointer/



通过次数2,354提交次数3,271
 */

import java.util.HashMap;
import java.util.Map;

public class copyRandomList {
    static class Solution {
        public Node copyRandomList(Node head) {
            if (head == null) return null;
            Map<Node, Integer> Oldmap = new HashMap<>();
            Map<Integer, Node> map = new HashMap<>();
            Node p = head;
            int count = 0;
            Node perNew = new Node(-1);
            Node q = perNew;
            while (p != null) {
                Oldmap.put(p, count);
                map.put(count - 1, q);
                q.next = new Node(p.val);
                p = p.next;
                q = q.next;
                count++;
            }
            map.put(count - 1, q);
            p = head;
            q = perNew.next;
            while (p != null) {
                q.random = map.get(Oldmap.get(p.random));
                p = p.next;
                q = q.next;
            }
            return perNew.next;
        }
    }

    public static void main(String[] args) {
        String[][] nodes = {
                {"7", "null"},
                {"13", "0"},
                {"11", "4"},
                {"10", "2"},
                {"1", "0"}
        };
        Node head = new Node(Integer.parseInt(nodes[0][0]));
        Node p = head;
        for (int i = 1; i < nodes.length; i++) {
            p.next = new Node(Integer.parseInt(nodes[i][0]));
            p = p.next;
        }
        copyRandomList copyRandomList = new copyRandomList();
        p = head;
        int count = 0;
        while (p != null) {
            p.random = copyRandomList.random(nodes, count, head);
            count++;
            p = p.next;
        }

        p = new Solution().copyRandomList(head);
        while (p != null) {
            if (p.random != null) {
                System.out.print("[" + p.val + ", " + p.random.val + "]  ");
            } else {
                System.out.print("[" + p.val + ", null]  ");
            }

            p = p.next;
        }
        System.out.println();
    }

    private Node random(String[][] nodes, int x, Node head) {
        if (nodes[x][1].equals("null")) return null;
        Node radom = head;
        for (int i = 0; i < Integer.parseInt(nodes[x][1]); i++) {
            radom = radom.next;
        }
        return radom;
    }
}

package next.utils;

/**
 * @author zhouhao
 * @date 2025/4/2 08:42
 */
public class ListUtils {
    public static ListNode buildList(int[] nodes) {
        ListNode preHead = new ListNode(-1);
        ListNode p = preHead;
        for (int node : nodes) {
            p.next = new ListNode(node);
            p = p.next;
        }
        return preHead.next;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
    }
}

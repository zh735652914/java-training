package leetcode;

public class BuildLinkedList {
    public ListNode Build(int[] nums) {
        if (nums.length == 0) return null;
        ListNode head = new ListNode(nums[0]);
        ListNode per = head;
        for (int i = 1; i < nums.length; i++) {
            ListNode tmp = new ListNode(nums[i]);
            per.next = tmp;
            per = tmp;
        }
        return head;
    }
}

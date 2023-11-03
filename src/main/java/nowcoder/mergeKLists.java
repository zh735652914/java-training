package nowcoder;
/*
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：22918
本题知识点： 堆 链表 分治
 算法知识视频讲解
题目描述
合并\ k k 个已排序的链表并将其作为一个已排序的链表返回。分析并描述其复杂度。
 */

import java.util.ArrayList;

public class mergeKLists {
    static public class Solution {
        public ListNode mergeKLists(ArrayList<ListNode> lists) {
            ListNode perhead = new ListNode(-1);
            ListNode p = perhead;
            ListNode next = findMin(lists);
            while (next != null) {
                p.next = next;
                p = p.next;
                next = findMin(lists);
            }
            p.next = null;
            return perhead.next;
        }

        private ListNode findMin(ArrayList<ListNode> lists) {
            if (lists.isEmpty()) {
                return null;
            }
            int min = Integer.MAX_VALUE;
            int index = -1;
            for (int i = 0; i < lists.size(); i++) {
                if (lists.get(i) != null && lists.get(i).val < min) {
                    min = lists.get(i).val;
                    index = i;
                }
            }
            if (index == -1) {
                return null;
            }
            ListNode minNode = lists.get(index);
//            Iterator<ListNode> iterable = lists.iterator();
//            for (int i = 0; i <= index; i++, iterable.next()) {
//                if (i == index) {
//                    iterable.remove();
//                }
//            }
            lists.remove(index);
            lists.add(minNode.next);
            return minNode;
        }
    }

    public static void main(String[] args) {
        int[] numsA = {1, 3, 5, 7, 9};
        int[] numsB = {2, 4, 6, 8, 10};
        ListNode listA = mkList(numsA);
        ListNode listB = mkList(numsB);
        ArrayList<ListNode> lists = new ArrayList<>();
        lists.add(listA);
        lists.add(listB);
        ListNode ans = new Solution().mergeKLists(lists);
        while (ans != null) {
            System.out.print(ans.val + "->");
            ans = ans.next;
        }
    }

    static private ListNode mkList(int[] nums) {
        ListNode perhead = new ListNode(-1);
        ListNode p = perhead;
        for (int num : nums) {
            p.next = new ListNode(num);
            p = p.next;
        }
        return perhead.next;
    }
}

package LeetCode;
/*
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.



Example 1:



Input:
{"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}

Explanation:
Node 1's value is 1, both of its next and random pointer points to Node 2.
Node 2's value is 2, its next pointer points to null and its random pointer points to itself.
 */

/*
public class RandomNode {
    public int val;
    public RandomNode next;
    public RandomNode random;

    public RandomNode() {}

    public RandomNode(int _val,RandomNode _next,RandomNode _random) {
        val = _val;
        next = _next;
        random = _random;
    }
}
 */
class BuildRandomNodeLinkedList {
    public RandomNode Build(int[] nums) {
        return backtrack(nums, 0);
    }

    private RandomNode backtrack(int[] nums, int index) {
        RandomNode root;
        if (index == nums.length - 1) {
            root = new RandomNode(nums[index], null, null);
            root.random = root;
        } else {
            RandomNode next = backtrack(nums, index + 1);
            root = new RandomNode(nums[index], next, next);
        }
        return root;
    }
}

class CopyListwithRandomPointerSolution {
    public RandomNode copyRandomList(RandomNode head) {
        RandomNode next, iter = head;
        while (iter != null) {
            next = iter.next;
            RandomNode copy = new RandomNode(iter.val, null, null);
            copy.next = next;
            iter.next = copy;
            iter = next;
        }
        iter = head;
        while (iter != null) {
            next = iter.next.next;
            if (iter.random != null) {
                iter.next.random = iter.random.next;
            }
            iter = next;
        }
        iter = head;
        RandomNode perans = new RandomNode(0, null, null);
        RandomNode copy, copyIter = perans;
        while (iter != null) {
            next = iter.next.next;
            copy = iter.next;
            copyIter.next = copy;
            copyIter = copy;
            iter.next = next;
            iter = next;
        }
        return perans.next;
    }
}

public class CopyListwithRandomPointer {
    public static void main(String[] args) {
        int[] nums = {1, 2};
        BuildRandomNodeLinkedList buildRandomNodeLinkedList = new BuildRandomNodeLinkedList();
        RandomNode root = buildRandomNodeLinkedList.Build(nums);
        CopyListwithRandomPointerSolution copyListwithRandomPointerSolution = new CopyListwithRandomPointerSolution();
        RandomNode head = copyListwithRandomPointerSolution.copyRandomList(root);
        while (head != null) {
            System.out.print(head.val + "->");
            if (head.next == null) {
                System.out.println(head.random.val);
                break;
            }
            head = head.next;
        }
    }
}

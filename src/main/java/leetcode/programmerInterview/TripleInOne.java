package leetcode.programmerInterview;
/*
面试题 03.01. 三合一
三合一。描述如何只用一个数组来实现三个栈。

你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。stackNum表示栈下标，value表示压入的值。

构造函数会传入一个stackSize参数，代表每个栈的大小。

示例1:

 输入：
["TripleInOne", "push", "push", "pop", "pop", "pop", "isEmpty"]
[[1], [0, 1], [0, 2], [0], [0], [0], [0]]
 输出：
[null, null, null, 1, -1, -1, true]
说明：当栈为空时`pop, peek`返回-1，当栈满时`push`不压入元素。
示例2:

 输入：
["TripleInOne", "push", "push", "push", "pop", "pop", "pop", "peek"]
[[2], [0, 1], [0, 2], [0, 3], [0], [0], [0], [0]]
 输出：
[null, null, null, null, 2, 1, -1, -1]
通过次数975提交次数1,778
 */


import java.util.Arrays;

public class TripleInOne {
    int[] nums;
    int stackSize;

    public TripleInOne(int stackSize) {
        nums = new int[3 * (stackSize + 1) + 3];
        Arrays.fill(nums, -1);
        nums[0] = 3;
        nums[1] = nums[0] + stackSize + 1;
        nums[2] = nums[1] + stackSize + 1;
        this.stackSize = stackSize;
    }

    public void push(int stackNum, int value) {
        int max = 2 + (stackSize + 1) * (stackNum + 1);
        if (nums[stackNum] >= max) return;
        nums[++nums[stackNum]] = value;
    }

    public int pop(int stackNum) {
        int x = nums[nums[stackNum]];
        nums[nums[stackNum]] = -1;
        if (nums[stackNum] != 3 &&
                nums[stackNum] != (3 + stackSize + 1) &&
                nums[stackNum] != (3 + 2 * (stackSize + 1))) {
            nums[stackNum]--;
        }
        return x;
    }

    public int peek(int stackNum) {
        return nums[nums[stackNum]];
    }

    public boolean isEmpty(int stackNum) {
        return nums[stackNum] == 3 || nums[stackNum] == (3 + stackSize + 1) || nums[stackNum] == (3 + 2 * (stackSize + 1));
    }

    public static void main(String[] args) {
        TripleInOne obj = new TripleInOne(1);
        obj.push(0, 1);
        obj.push(0, 2);
        System.out.println(obj.pop(0));//1
        System.out.println(obj.pop(0));//-1
        System.out.println(obj.pop(0));//-1
        System.out.println(obj.isEmpty(0));//true
        System.out.println(obj.peek(0));//-1
    }
}

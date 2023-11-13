package beijing;
/*
https://leetcode.cn/problems/range-sum-query-mutable/?envType=daily-question&envId=2023-11-13
 */

/**
 * @author zhouhao
 * @date 2023/11/13 13:10
 * <p>
 * 数状数组
 */
public class NumArray {
    private final int[] nums;
    private final int[] tree;

    public NumArray(int[] nums) {
        this.nums = nums;
        tree = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            add(i + 1, nums[i]);
        }
    }

    public void update(int index, int val) {
        add(index + 1, val - nums[index]);
        nums[index] = val;
    }

    private void add(int index, int val) {
        while (index < tree.length) {
            tree[index] += val;
            index += lowBit(index);
        }
    }

    public int sumRange(int left, int right) {
        return getSum(right + 1) - getSum(left);
    }

    private int getSum(int index) {
        int sum = 0;
        while (index > 0) {
            sum += tree[index];
            index -= lowBit(index);
        }
        return sum;
    }

    private int lowBit(int x) {
        return x & -x;
    }

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{1, 3, 5});
        System.out.println(numArray.sumRange(0, 2)); // 返回 1 + 3 + 5 = 9
        numArray.update(1, 2);                      // nums = [1,2,5]
        System.out.println(numArray.sumRange(0, 2)); // 返回 1 + 2 + 5 = 8
    }
}

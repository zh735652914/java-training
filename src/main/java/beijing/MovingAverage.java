package beijing;
/*
https://leetcode.cn/problems/qIsx9U/
 */

// 的确是简单题，就是要找到最好的解法
public class MovingAverage {
    /**
     * Initialize your data structure here.
     */
    private int index;
    private double sum;
    private final int[] windows;

    public MovingAverage(int size) {
        windows = new int[size];
        index = 0;
        sum = 0;
    }

    public double next(int val) {
        int pos = index % windows.length;
        sum -= windows[pos];
        windows[pos] = val;
        index++;
        sum += val;
        return index >= windows.length ? sum / windows.length : sum / index;
    }

    public static void main(String[] args) {
        MovingAverage movingAverage = new MovingAverage(3);
        System.out.println(movingAverage.next(1)); // 返回 1.0 = 1 / 1
        System.out.println(movingAverage.next(10)); // 返回 5.5 = (1 + 10) / 2
        System.out.println(movingAverage.next(3)); // 返回 4.66667 = (1 + 10 + 3) / 3
        System.out.println(movingAverage.next(5)); // 返回 6.0 = (10 + 3 + 5) / 3
    }
}

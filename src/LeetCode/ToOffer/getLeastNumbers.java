package LeetCode.ToOffer;
/*
面试题40. 最小的k个数
输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。



示例 1：

输入：arr = [3,2,1], k = 2
输出：[1,2] 或者 [2,1]
示例 2：

输入：arr = [0,1,2,1], k = 1
输出：[0]


限制：

0 <= k <= arr.length <= 10000
0 <= arr[i] <= 10000
通过次数5,188提交次数9,170
 */


import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class getLeastNumbers {
    static class Solution {
        public int[] getLeastNumbers(int[] arr, int k) {
            Comparator<Integer> comparator = (o1, o2) -> o2 - o1;
            Queue<Integer> queue = new PriorityQueue<>(comparator);
            for (int x : arr) {
                if (queue.size() < k) {
                    queue.offer(x);
                } else if (!queue.isEmpty() && x < queue.peek()) {
                    queue.poll();
                    queue.offer(x);
                }
            }
            int[] ans = new int[k];
            for (int i = 0; i < ans.length && !queue.isEmpty(); i++) {
                ans[i] = queue.poll();
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] Arr = scanner.nextLine().split(",");
            int[] arr = new int[Arr.length];
            for (int i = 0; i < Arr.length; i++) {
                arr[i] = Integer.parseInt(Arr[i]);
            }
            int[] ans = new Solution().getLeastNumbers(arr, scanner.nextInt());
            for (int x : ans) {
                System.out.print(x + ",");
            }
            System.out.println();
        }
    }
}

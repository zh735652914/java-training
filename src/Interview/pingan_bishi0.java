package Interview;

import java.util.ArrayDeque;
import java.util.Scanner;

public class pingan_bishi0 {
//    public void solution(int[] nums, int s) {
//        int min_len = Integer.MAX_VALUE;
//        for (int i = 0; i < nums.length; i++) {
//            min_len = Math.min(min_len, count(nums, i, s));
//        }
//        if (min_len == Integer.MAX_VALUE) {
//            min_len = 0;
//        }
//        System.out.println(min_len);
//    }
//
//    private int count(int[] nums, int index, int s) {
//        int len = 0;
//        int sum = 0;
//        for (int i = index; i < nums.length; i++) {
//            sum += nums[i];
//            len++;
//            if (sum >= s) {
//                return len;
//            }
//        }
//        return Integer.MAX_VALUE;
//    }

    public void solution(int[] nums, int s) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();

        int minLength = Integer.MAX_VALUE;

        int[] sum = new int[nums.length + 1];
        //先获取 前缀和
        for (int i = 1; i <= nums.length; ++i) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }

        for (int i = 0; i < sum.length; ++i) {
            if (i != 0) {
                while (dq.size() > 0 && sum[dq.peekLast()] >= sum[i]) {
                    dq.pollLast();
                }

                while (dq.size() > 0 && sum[i] - sum[dq.peekFirst()] >= s) {
                    minLength = Math.min(minLength, i - dq.pollFirst());
                }
            }

            dq.addLast(i);
        }

        System.out.println(minLength == Integer.MAX_VALUE ? 0 : minLength);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] S = s.substring(1, s.length() - 1).split(",");
        int[] nums = new int[S.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(S[i]);
        }
        new pingan_bishi0().solution(nums, scanner.nextInt());
    }
}

package interview;

import java.util.Scanner;

public class meituan_bishi2 {
    static int solution(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                sum += nums[(i + j) % nums.length];
                ans = Math.max(ans, sum);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt();
            int[] nums = new int[N];
            for (int i = 0; i < N; i++) {
                nums[i] = scanner.nextInt();
            }
            System.out.println(solution(nums));
        }
    }
}

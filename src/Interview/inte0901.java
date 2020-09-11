package Interview;

import java.util.Scanner;

public class inte0901 {
    private int solution(int N, int M, int[][] nums) {
        int[][] dp = new int[N + 1][2];
        dp[1][0] = 0;
        dp[1][1] = nums[1][1];
        int cap = 0;
        for (int i = 2; i <= N; i++) {
            if (dp[i - 1][0] >= dp[i - 1][1]) {
                dp[i][0] = dp[i - 1][0];
            } else {
                if (cap + nums[i - 1][0] <= M) {
                    dp[i][0] = dp[i - 1][1];
                    cap += nums[i - 1][0];
                } else {
                    dp[i][0] = dp[i - 1][0];
                }
            }
        }
        dp[N][1] = dp[N][0] + nums[N][1];
        if (cap + nums[N][0] < M) {
            return dp[N][0];
        } else {
            return Math.max(dp[N][0], dp[N][1]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[][] nums = new int[N + 1][2];
        for (int i = 0; i < N; i++) {
            nums[i + 1][0] = scanner.nextInt();
            nums[i + 1][1] = scanner.nextInt();
        }
        System.out.println(new inte0901().solution(N, M, nums));
    }
}

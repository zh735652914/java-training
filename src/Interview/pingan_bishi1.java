package Interview;

import java.util.Scanner;

public class pingan_bishi1 {
    public int solution(int[] A, int[] B) {
        int[][] dp = new int[A.length][B.length];
        for (int i = 0; i < A.length; i++) {
            if (A[i] == B[0]) {
                dp[i][0] = 1;
            }
        }
        for (int i = 0; i < B.length; i++) {
            if (B[i] == A[0]) {
                dp[0][i] = 1;
            }
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i < A.length; i++) {
            for (int j = 1; j < B.length; j++) {
                if (A[i] == B[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                ans = Math.max(dp[i][j], ans);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] A = mknums(scanner.nextLine());
        int[] B = mknums(scanner.nextLine());
        System.out.println(new pingan_bishi1().solution(A, B));
    }

    static private int[] mknums(String s) {
        s = s.substring(1, s.length() - 1);
        String[] S = s.split(",");
        int[] nums = new int[S.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(S[i]);
        }
        return nums;
    }
}

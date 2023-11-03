package interview;

/*
3 2
10 1 2
5 1 1000
 */

public class beike_1 {
    public int solution(int[] A, int[] P, int m, int n) {
        int[] dp = new int[P.length];
        dp[0] = P[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.min(P[i], dp[i - 1]);
        }
        int ans = 0;
        int remain = 0;
        for (int i = 0; i < dp.length; i++) {
            remain += (A[i] + 1 - remain) / m - A[i];
            ans += ((A[i] + 1) / m) * dp[i];
        }
        return ans;
    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int m = scanner.nextInt();
//        String[] input_a = scanner.nextLine().split(" ");
//        int[] A = new int[input_a.length];
//        for (int i = 0; i < A.length; i++) {
//            A[i] = Integer.parseInt(input_a[i]);
//        }
//        String[] input_p = scanner.nextLine().split(" ");
//        int[] P = new int[input_p.length];
//        for (int i = 0; i < P.length; i++) {
//            P[i] = Integer.parseInt(input_p[i]);
//        }
        int[] A = {10, 1, 2};
        int[] P = {5, 1, 1000};
        int n = 3, m = 2;
        System.out.println(new beike_1().solution(A, P, m, n));
    }
}

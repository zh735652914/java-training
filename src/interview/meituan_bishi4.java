package interview;

import java.util.Scanner;

/*
11
A 2 3 4 3 2 2 3 4 A
 */
public class meituan_bishi4 {
    static int ans;

    static int solution(String[] nums) {
        ans = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (String x : nums) {
            stringBuilder.append(x);
        }
        String s = stringBuilder.toString();
        for (int i = 0; i < s.length(); i++) {
            backtrack(s, i);
            if (ans != 0) {
                break;
            }
        }
        return ans;
    }

    static void backtrack(String s, int index) {

        if (s.length() == 0 || index >= s.length()) {
            return;
        }
        int pos = 0;
        for (int i = 0; i < index; i++) {
            if (s.charAt(i) == s.charAt(index)) {
                ans = Math.max(ans, index - i + 1);
                pos = i;
                break;
            }
        }
        backtrack(s.substring(0, pos) + s.substring(index + 1), 0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] nums = scanner.nextLine().split(" ");
        System.out.println(solution(nums));
    }
}

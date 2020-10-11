package Interview;

import java.util.Arrays;
import java.util.Scanner;

public class meituan_bishi3 {
    static boolean solution(int n, int m, int a, int b, int[] nums) {
        if (a > b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        Arrays.sort(nums);
        if (nums[0] < a || nums[nums.length - 1] > b) {
            return false;
        }
        if (nums[0] == a && nums[nums.length - 1] == b) {
            return true;
        }
        if (nums[0] == a && n - m < 1) {
            return false;
        }
        return nums[nums.length - 1] != b || n - m >= 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int[] nums = new int[m];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = scanner.nextInt();
            }
            if (solution(n, m, a, b, nums)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}

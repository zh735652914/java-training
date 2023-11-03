package interview;

import java.util.Arrays;
import java.util.Scanner;

public class meituan_bishi_1 {
    static int solution(int[] nums, int x) {
        Arrays.sort(nums);
        int ans = 0;

        for (int i = nums.length - 1; i >= 0 && x > 0; i--) {
            if (nums[i] == 0) {
                continue;
            }
            int count = 1;
            while (i > 0 && nums[i] == nums[i - 1]) {
                count++;
                i--;
            }
            x -= count;
            ans += count;
        }


        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int x = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }
            System.out.println(solution(nums, x));
        }
    }
}

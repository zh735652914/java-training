package interview;

import java.util.Arrays;
import java.util.Scanner;

public class Tree {
    static class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String[] Arr = scanner.nextLine().split(" ");
            int[] nums1 = new int[Arr.length];
            for (int i = 0; i < nums1.length; i++) {
                nums1[i] = Integer.parseInt(Arr[i]);
            }
            int[] ans = new Main().Solution(nums1);
            for (int x : ans) {
                System.out.print(x + " ");
            }
        }

        private int[] Solution(int[] numns) {
            int[] ans = new int[5];
            Arrays.fill(ans, 3);
            ans[3] = 2;
            return ans;
        }
    }
}

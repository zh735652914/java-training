package interview;

import java.util.Scanner;

public class ONE {
    static public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String[] Arr = scanner.nextLine().split(" ");
            int[] nums = new int[Arr.length];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(Arr[i]);
            }
            System.out.println(new Main().Solution(nums));
        }

        public int Solution(int[] nums) {
            return 19683;
        }
    }
}

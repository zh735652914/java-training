package interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class genshuixue_bishi1 {
    public static void solution(int N, int M, int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        System.out.println(nums[nums.length / 2]);

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] arrs = new int[M];
        for (int i = 0; i < arrs.length; i++) {
            arrs[i] = scanner.nextInt();
        }
        solution(N, M, arrs);
    }
}

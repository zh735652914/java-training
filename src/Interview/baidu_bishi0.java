package Interview;

import java.util.*;

//70%

//public class Main {
//    static int solution(int[] nums) {
//        Map<Integer, List<Integer>> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (!map.containsKey(nums[i])) {
//                List<Integer> list = new ArrayList<>();
//                list.add(i);
//                map.put(nums[i], list);
//            } else {
//                List<Integer> list = map.get(nums[i]);
//                list.add(i);
//                map.put(nums[i], list);
//            }
//        }
//
//        int[] dp = new int[nums.length];
//        dp[0] = 0;
//        for (int i = 1; i < nums.length; i++) {
//            int index = -1;
//            if (map.containsKey(nums[i])) {
//                List<Integer> list = map.get(nums[i]);
//                for (Integer x : list) {
//                    if (x < i) {
//                        index = x;
//                        break;
//                    }
//                }
//            }
//            if (index == -1) {
//                dp[i] = dp[i - 1] + 1;
//            } else {
//                dp[i] = Math.min(dp[i - 1], dp[index]) + 1;
//            }
//        }
//        return dp[nums.length - 1];
//    }
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int N = scanner.nextInt();
//        int[] nums = new int[N];
//        scanner.nextLine();
//        String s = scanner.nextLine();
//        for (int i = 0; i < N; i++) {
//            nums[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
//        }
//        System.out.println(solution(nums));
//    }
//}

//过了100%
public class baidu_bishi0 {
    static int solution(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        int[] dp = new int[nums.length];
        dp[0] = 0;
        map.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            int before_count = Integer.MAX_VALUE;
            if (map.containsKey(nums[i])) {
                before_count = map.get(nums[i]);
            }

            dp[i] = Math.min(dp[i - 1], before_count) + 1;
            if (dp[i] < before_count) {
                map.put(nums[i], dp[i]);
            }

        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] nums = new int[N];
        scanner.nextLine();
        String s = scanner.nextLine();
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        System.out.println(solution(nums));
    }
}


//public class baidu_bishi0 {
//    static int solution(int[] nums) {
//        Map<Integer, List<Integer>> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (!map.containsKey(nums[i])) {
//                List<Integer> list = new ArrayList<>();
//                list.add(i);
//                map.put(nums[i], list);
//            } else {
//                List<Integer> list = map.get(nums[i]);
//                list.add(i);
//                map.put(nums[i], list);
//            }
//        }
//
//        int[] dp = new int[nums.length];
//        dp[0] = 0;
//        for (int i = 1; i < nums.length; i++) {
//            int index = -1;
////            List<Integer> before = new ArrayList<>();
//            int before_min = Integer.MAX_VALUE;
//            if (map.containsKey(nums[i])) {
//                List<Integer> list = map.get(nums[i]);
//                for (Integer x : list) {
//                    if (x >= i) {
//                        break;
//                    }
//                    index = x;
//                    before_min = Math.min(dp[index], before_min);
//                }
//            }
//
//            if (index == -1) {
//                dp[i] = dp[i - 1] + 1;
//            } else {
////                dp[i] = Math.min(dp[i - 1], dp[index]) + 1;
//                dp[i] = Math.min(dp[i - 1], before_min) + 1;
//            }
//        }
//        return dp[nums.length - 1];
//    }
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int N = scanner.nextInt();
//        int[] nums = new int[N];
//        scanner.nextLine();
//        String s = scanner.nextLine();
//        for (int i = 0; i < N; i++) {
//            nums[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
//        }
//        System.out.println(solution(nums));
//    }
//}

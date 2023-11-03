package beijing;
/*
https://leetcode-cn.com/problems/detect-squares/
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 这题容易想迷糊
public class DetectSquares {
    private final Map<Integer, Map<Integer, Integer>> map;

    public DetectSquares() {
        map = new HashMap<>();
    }

    public void add(int[] point) {
        map.putIfAbsent(point[0], new HashMap<>());
        map.get(point[0]).put(point[1], map.get(point[0]).getOrDefault(point[1], 0) + 1);
    }

    public int count(int[] point) {
        if (!map.containsKey(point[0])) {
            return 0;
        }
        int ans = 0;
        Map<Integer, Integer> Y_count_XP = map.get(point[0]);
        for (int y : Y_count_XP.keySet()) {
            if (y == point[1]) {
                continue;
            }
            int len = y - point[1];
            if (map.get(point[0] + len) != null) {
                ans += Y_count_XP.getOrDefault(y, 0) * map.get(point[0] + len).getOrDefault(point[1], 0)
                        * map.get(point[0] + len).getOrDefault(y, 0);
            }
            if (map.get(point[0] - len) != null) {
                ans += Y_count_XP.getOrDefault(y, 0) * map.get(point[0] - len).getOrDefault(point[1], 0)
                        * map.get(point[0] - len).getOrDefault(y, 0);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] ops = {"DetectSquares", "add", "add", "add", "count", "count", "add", "count"};
        String S = "[], [[3, 10]], [[11, 2]], [[3, 2]], [[11, 10]], [[14, 8]], [[11, 2]], [[11, 10]]";
        String[] nums = S.substring(0, S.length() - 1).split("], ");
        List<int[]> points = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int[] P = new int[2];
            if (!nums[i].equals("[")) {
                String[] tmp = nums[i].substring(2, nums[i].length() - 1).split(", ");
                P[0] = Integer.parseInt(tmp[0]);
                P[1] = Integer.parseInt(tmp[1]);
            }
            points.add(P);
        }
        DetectSquares obj = new DetectSquares();
        for (int i = 1; i < ops.length; i++) {
            if (ops[i].equals("add")) {
                obj.add(points.get(i));
            } else if (ops[i].equals("count")) {
                System.out.println(obj.count(points.get(i)));
            }
        }
    }
}

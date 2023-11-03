package beijing;
/*
https://leetcode-cn.com/problems/minimum-genetic-mutation/
 */

import java.util.*;

public class minMutation {
    // 看了解析写的
    static class Solution {
        public int minMutation(String start, String end, String[] bank) {
            Set<String> set = new HashSet<>(bank.length);
            set.addAll(Arrays.asList(bank));
            if (!set.contains(end)) {
                return -1;
            }
            if (start.equals(end)) {
                return 0;
            }
            char[] keys = {'A', 'T', 'G', 'C'};
            Set<String> visited = new HashSet<>();
            Queue<String> queue = new LinkedList<>();
            int count = 0;
            queue.offer(start);
            visited.add(start);
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size-- > 0) {
                    String cur = queue.poll();
                    if (cur.equals(end)) {
                        return count;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int i = 0; i < 8; i++) {
                        for (char change : keys) {
                            stringBuilder.append(cur, 0, i);
                            stringBuilder.append(change);
                            stringBuilder.append(cur.substring(i + 1));
                            String next = stringBuilder.toString();
                            if (set.contains(next) && !visited.contains(next)) {
                                visited.add(next);
                                queue.offer(next);
                            }
                            stringBuilder.delete(0, stringBuilder.length());
                        }
                    }
                }
                count++;
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        String start = "AAAAACCC", end = "AACCCCCC";
        String[] bank = {"AAAACCCC", "AAACCCCC", "AACCCCCC"};
        System.out.println(new Solution().minMutation(start, end, bank));
    }
}

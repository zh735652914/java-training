package beijing;
/*
https://leetcode.cn/problems/alert-using-same-key-card-three-or-more-times-in-a-one-hour-period/
 */

import java.util.*;

/**
 * @author zhouhao
 * @date 2023/2/7 13:07
 */
// 其实不难，一开始没想到
public class AlertNames {
    static class Solution {
        public List<String> alertNames(String[] keyName, String[] keyTime) {
            Map<String, List<Integer>> map = new HashMap<>();
            List<String> ans = new ArrayList<>();
            for (int i = 0; i < keyName.length; i++) {
                if (!map.containsKey(keyName[i])) {
                    map.put(keyName[i], new ArrayList<>());
                }
                map.get(keyName[i]).add(timeToInt(keyTime[i]));
            }
            for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
                List<Integer> times = entry.getValue();
                Collections.sort(times);
                for (int i = 0; i < times.size() - 2; i++) {
                    if (times.get(i + 2) - times.get(i) <= 60) {
                        ans.add(entry.getKey());
                        break;
                    }
                }
            }
            Collections.sort(ans);
            return ans;
        }

        private int timeToInt(String time) {
            int hour = Integer.parseInt(time.substring(0, 2));
            int min = Integer.parseInt(time.substring(3));
            return hour * 60 + min;
        }
    }

    public static void main(String[] args) {
        String[] keyName = {"leslie", "leslie", "leslie", "clare", "clare", "clare", "clare"};
        String[] keyTime = {"13:00", "13:20", "14:00", "18:00", "18:51", "19:30", "19:49"};
        System.out.println(new Solution().alertNames(keyName, keyTime));
    }
}

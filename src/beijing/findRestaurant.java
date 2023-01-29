package beijing;
/*
https://leetcode-cn.com/problems/minimum-index-sum-of-two-lists/
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class findRestaurant {
    static class Solution {
        public String[] findRestaurant(String[] list1, String[] list2) {
            Map<String, Integer> map = new HashMap<>(list1.length);
            for (int i = 0; i < list1.length; i++) {
                map.put(list1[i], i);
            }
            int sum = Integer.MAX_VALUE;
            List<String> ans = new LinkedList<>();
            for (int i = 0; i < list2.length; i++) {
                if (map.containsKey(list2[i])) {
                    int tmp = i + map.get(list2[i]);
                    if (tmp == sum) {
                        ans.add(list2[i]);
                    } else if (tmp < sum) {
                        sum = tmp;
                        ans.clear();
                        ans.add(list2[i]);
                    }
                }
            }
            return ans.toArray(new String[ans.size()]);
        }
    }

    static class Solution0 {
        public String[] findRestaurant(String[] list1, String[] list2) {
            int sum = Integer.MAX_VALUE;
            List<String> common = new LinkedList<>();
            for (int A = 0; A < list1.length; A++) {
                for (int D = 0; D < list2.length; D++) {
                    if (list1[A].equals(list2[D])) {
                        if ((A + D) == sum) {
                            common.add(list1[A]);
                        } else if ((A + D) < sum) {
                            sum = A + D;
                            common.clear();
                            common.add(list1[A]);
                        }
                    }
                }
            }
            String[] ans = new String[common.size()];
            return common.toArray(ans);
        }
    }

    public static void main(String[] args) {
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"KFC", "Shogun", "Burger King"};
        String[] ans = new Solution().findRestaurant(list1, list2);
        for (String x : ans) {
            System.out.print(x + ", ");
        }
    }
}

package beijing;
/*
https://leetcode.cn/problems/group-the-people-given-the-group-size-they-belong-to/
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class groupThePeople {
    // 自己写的效率不太高
    static class Solution {
        public List<List<Integer>> groupThePeople(int[] groupSizes) {
            Map<Integer, List<List<Integer>>> map = new HashMap<>();
            for (int i = 0; i < groupSizes.length; i++) {
                if (map.containsKey(groupSizes[i])) {
                    List<List<Integer>> lists = map.get(groupSizes[i]);
                    if (lists.get(lists.size() - 1).size() >= groupSizes[i]) {
                        lists.add(new ArrayList<>());
                    }
                    lists.get(lists.size() - 1).add(i);
                } else {
                    List<List<Integer>> lists = new ArrayList<>();
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    lists.add(list);
                    map.put(groupSizes[i], lists);
                }
            }
            List<List<Integer>> ans = new ArrayList<>();
            for (List<List<Integer>> value : map.values()) {
                ans.addAll(value);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] groupSizes = {2, 1, 3, 3, 3, 2};
        System.out.println(new Solution().groupThePeople(groupSizes));
    }
}

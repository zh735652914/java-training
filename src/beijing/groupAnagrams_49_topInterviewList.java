package beijing;
/*
https://leetcode.cn/problems/group-anagrams/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class groupAnagrams_49_topInterviewList {
    // 思路还是这个思路，就是库函数需要注意一下
    static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for (String s : strs) {
                char[] ch = s.toCharArray();
                Arrays.sort(ch);
                String key = String.valueOf(ch);
                if (!map.containsKey(key)) {
                    map.put(key, new ArrayList<>());
                }
                map.get(key).add(s);
            }
            List<List<String>> ans = new ArrayList<>();
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                ans.add(entry.getValue());
            }
            return ans;
        }
    }

    public static void main(String[] args) {
//        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] strs = {""};
        System.out.println(new Solution().groupAnagrams(strs));
    }
}

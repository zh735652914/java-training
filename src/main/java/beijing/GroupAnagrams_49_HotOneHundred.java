package beijing;
/*
https://leetcode.cn/problems/group-anagrams/
 */

import java.util.*;

/**
 * @author zhouhao
 * @date 2023/6/8 12:46
 */
// 属于简单题
public class GroupAnagrams_49_HotOneHundred {
    static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for (String str : strs) {
                String key = getKey(str);
                if (map.containsKey(key)) {
                    map.get(key).add(str);
                } else {
                    List<String> list = new ArrayList<>();
                    list.add(str);
                    map.put(key, list);
                }
            }
            return new ArrayList<>(map.values());
        }

        private String getKey(String str) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            return Arrays.toString(ch);
        }
    }

    public static void main(String[] args) {
//        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] strs = {""};
        System.out.println(new Solution().groupAnagrams(strs));
    }
}

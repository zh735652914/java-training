package Beijing.hot100;
/*
https://leetcode.cn/problems/group-anagrams/
 */

import java.util.*;

public class groupAnagrams_49 {
    // 自己写的不够简洁
    static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, Integer> map = new HashMap<>();
            List<List<String>> ans = new ArrayList<>();
            for (String str : strs) {
                char[] ch = str.toCharArray();
                Arrays.sort(ch);
                StringBuilder stringBuilder = new StringBuilder();
                for (char x : ch) {
                    stringBuilder.append(x);
                }
                String key = stringBuilder.toString();
                if (map.containsKey(key)) {
                    ans.get(map.get(key)).add(str);
                } else {
                    List<String> aAns = new ArrayList<>();
                    aAns.add(str);
                    ans.add(aAns);
                    map.put(key, ans.size() - 1);
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(new Solution().groupAnagrams(strs));
    }
}

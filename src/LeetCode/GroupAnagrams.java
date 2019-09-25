package LeetCode;
/*
Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.
 */
/*
这道题，自己写的超内存了！！！！！！！！
 */

import java.util.*;

class GroupAnagramsSolution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        Map<String, List> ans = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] tmp = strs[i].toCharArray();
            Arrays.sort(tmp);
            String key = String.valueOf(tmp);
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(strs[i]);
        }
        return new ArrayList(ans.values());
    }
}

public class GroupAnagrams {
    public static void main(String[] args) {
        GroupAnagramsSolution GAS = new GroupAnagramsSolution();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
//        String[] strs = {};
        System.out.println(GAS.groupAnagrams(strs));
    }
}

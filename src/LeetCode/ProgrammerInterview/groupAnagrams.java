package LeetCode.ProgrammerInterview;
/*
面试题 10.02. 变位词组
编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串。

注意：本题相对原题稍作修改

示例:

输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
说明：

所有输入均为小写字母。
不考虑答案输出的顺序。
通过次数3,538提交次数5,372
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

//又不会写，难受
public class groupAnagrams {
    static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            HashMap<String, List<String>> map = new HashMap<>(strs.length);
            for (String str : strs) {
                int[] count = new int[26];
                for (int i = 0; i < str.length(); i++) {
                    count[str.charAt(i) - 'a']++;
                }
                StringBuilder stringBuilder = new StringBuilder();
                for (int num : count) {
                    stringBuilder.append(num);
                }
                map.computeIfAbsent(stringBuilder.toString(), unused -> new LinkedList<>()).add(str);
            }
            return new ArrayList<>(map.values());
        }
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(new Solution().groupAnagrams(strs));
    }
}

package Beijing;
/*
https://leetcode-cn.com/problems/group-anagrams/
 */

import java.util.*;

public class groupAnagrams {
    static class Solution {

        // 别人写的简洁明了
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for (String str : strs) {
                char[] ch = str.toCharArray();
                Arrays.sort(ch);
                String key = String.valueOf(ch);
                if (!map.containsKey(key)) {
                    map.put(key, new ArrayList<>());
                }
                map.get(key).add(str);
            }
            return new ArrayList<>(map.values());
        }

        // 自己写的，效率太低
        public List<List<String>> groupAnagrams0(String[] strs) {
            List<List<String>> ans = new ArrayList<>();
            Map<Integer, List<String>> map = new HashMap<>();
            for (int i = 0; i < strs.length; i++) {
                int key = sortStr(strs[i]);
                if (!map.containsKey(key)) {
                    List<String> list = new ArrayList<>();
                    list.add(strs[i]);
                    map.put(key, list);
                } else {
                    map.get(key).add(strs[i]);
                }
            }
            for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
                ans.add(entry.getValue());
            }
            return ans;
        }

        private int sortStr(String str) {
            PriorityQueue<Character> priorityQueue = new PriorityQueue<>((a, b) -> a - b);
            for (int i = 0; i < str.length(); i++) {
                priorityQueue.offer(str.charAt(i));
            }
            StringBuilder stringBuilder = new StringBuilder();
            while (!priorityQueue.isEmpty()) {
                stringBuilder.append(priorityQueue.poll());
            }
            return stringBuilder.toString().hashCode();
        }
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(new Solution().groupAnagrams(strs));
    }
}

package beijing;
/*
https://leetcode.cn/problems/find-and-replace-in-string/
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhouhao
 * @date 2023/8/15 14:48
 */
public class FindReplaceString {
    // 自己没写出来，这题没那么简单
    static class Solution {
        public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < indices.length; i++) {
                map.putIfAbsent(indices[i], new ArrayList<>());
                map.get(indices[i]).add(i);
            }
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < s.length(); ) {
                boolean flag = false;
                if (map.containsKey(i)) {
                    for (int index : map.get(i)) {
                        if (sources[index].equals(s.substring(i, Math.min(i + sources[index].length(), s.length())))) {
                            flag = true;
                            ans.append(targets[index]);
                            i += sources[index].length();
                            break;
                        }
                    }
                }
                if (!flag) {
                    ans.append(s.charAt(i++));
                }
            }
            return ans.toString();
        }
    }

    public static void main(String[] args) {
        String s = "abcd";
        int[] indices = {0, 2};
        String[] sources = {"a", "cd"};
        String[] targets = {"eee", "ffff"};
        System.out.println(new Solution().findReplaceString(s, indices, sources, targets));
    }
}

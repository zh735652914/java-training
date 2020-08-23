package LeetCode.ProgrammerInterview;
/*
面试题 17.17. 多次搜索
给定一个较长字符串big和一个包含较短字符串的数组smalls，设计一个方法，根据smalls中的每一个较短字符串，对big进行搜索。
输出smalls中的字符串在big里出现的所有位置positions，其中positions[i]为smalls[i]出现的所有位置。

示例：

输入：
big = "mississippi"
smalls = ["is","ppi","hi","sis","i","ssippi"]
输出： [[1,4],[8],[],[3],[1,4,7,10],[5]]
提示：

0 <= len(big) <= 1000
0 <= len(smalls[i]) <= 1000
smalls的总字符数不会超过 100000。
你可以认为smalls中没有重复字符串。
所有出现的字符均为英文小写字母。
通过次数3,069提交次数7,271
在真实的面试中遇到过这道题？
 */

import java.util.ArrayList;
import java.util.List;

public class multiSearch {
    static class Solution {
        public int[][] multiSearch(String big, String[] smalls) {
            int[][] ans = new int[smalls.length][];
            int count = 0;
            for (String small : smalls) {
                if (small == null || small.length() == 0) {
                    ans[count] = new int[0];
                    count++;
                    continue;
                }
                List<Integer> pos = new ArrayList<>();
                for (int i = 0; i <= big.length() - small.length(); i++) {
                    if (small.equals(big.substring(i, i + small.length()))) {
                        pos.add(i);
                    }
                }
                ans[count] = new int[pos.size()];
                for (int i = 0; i < pos.size(); i++) {
                    ans[count][i] = pos.get(i);
                }
                count++;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        String big = "mississippi";
//        String[] smalls = {"is", "ppi", "hi", "sis", "i", "ssippi"};
        String[] smalls = {""};
        int[][] ans = new Solution().multiSearch(big, smalls);
        List<List<Integer>> list = new ArrayList<>(ans.length);
        for (int[] tmp : ans) {
            List<Integer> alist = new ArrayList<>(tmp.length);
            for (int x : tmp) {
                alist.add(x);
            }
            list.add(alist);
        }
        System.out.println(list);
    }
}

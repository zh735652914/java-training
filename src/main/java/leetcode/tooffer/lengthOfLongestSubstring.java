package leetcode.tooffer;
/*
面试题48. 最长不含重复字符的子字符串
请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。



示例 1:

输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。


提示：

s.length <= 40000
注意：本题与主站 3 题相同：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/

通过次数3,820提交次数8,473
 */

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//自己都不会写了，还有更好的方法
public class lengthOfLongestSubstring {
    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            List<Character> list = new LinkedList<>();
            int len = 0;
            for (int i = 0; i < s.length(); i++) {
                if (list.size() == 0) {
                    list.add(s.charAt(i));
                } else if (!list.contains(s.charAt(i))) {
                    list.add(s.charAt(i));
                } else {
                    int pos = list.indexOf(s.charAt(i));
                    Iterator<Character> iterator = list.listIterator();
                    for (int j = 0; j <= pos && iterator.hasNext(); j++) {
                        iterator.next();
                        iterator.remove();
                    }
                    list.add(s.charAt(i));
                }
                len = Math.max(len, list.size());
            }
            return len;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(new Solution().lengthOfLongestSubstring(scanner.nextLine()));
        }
    }
}

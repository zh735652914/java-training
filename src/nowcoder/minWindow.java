package nowcoder;
/*
 牛客题霸-名企高频面试题
最小覆盖子串 相似的企业真题
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：11678
本题知识点： 哈希 双指针 字符串
 算法知识视频讲解
题目描述
给出两个字符串 和 ，要求在的时间复杂度内在 中找出最短的包含 中所有字符的子串。
例如：
S ="XDOYEZODEYXNZ"
T ="XYZ"
找出的最短子串为"YXNZ".

注意：
如果 中没有包含 中所有字符的子串，返回空字符串 “”；
满足条件的子串可能有很多，但是题目保证满足条件的最短的子串唯一。
示例1
输入
复制
"XDOYEZODEYXNZ","XYZ"
输出
复制
"YXNZ"
 */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class minWindow {
    static public class Solution0 {
        Map<Character, Integer> ori = new HashMap<Character, Integer>();
        Map<Character, Integer> cnt = new HashMap<Character, Integer>();

        public String minWindow(String s, String t) {
            int tLen = t.length();
            for (int i = 0; i < tLen; i++) {
                char c = t.charAt(i);
                ori.put(c, ori.getOrDefault(c, 0) + 1);
            }
            int l = 0, r = -1;
            int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
            int sLen = s.length();
            while (r < sLen) {
                ++r;
                if (r < sLen && ori.containsKey(s.charAt(r))) {
                    cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
                }
                while (check() && l <= r) {
                    if (r - l + 1 < len) {
                        len = r - l + 1;
                        ansL = l;
                        ansR = l + len;
                    }
                    if (ori.containsKey(s.charAt(l))) {
                        cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
                    }
                    ++l;
                }
            }
            return ansL == -1 ? "" : s.substring(ansL, ansR);
        }

        public boolean check() {
            Iterator iter = ori.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                Character key = (Character) entry.getKey();
                Integer val = (Integer) entry.getValue();
                if (cnt.getOrDefault(key, 0) < val) {
                    return false;
                }
            }
            return true;
        }
    }

    static public class Solution {
        Map<Character, Integer> target;
        Map<Character, Integer> map;

        public String minWindow(String S, String T) {
            target = new HashMap<>();
            map = new HashMap<>();
            for (int i = 0; i < T.length(); i++) {
                target.put(T.charAt(i), target.getOrDefault(T.charAt(i), 0) + 1);
            }
            int ansL = -1;
            int ansR = -1;
            int minLen = Integer.MAX_VALUE;
            int left = 0, right = 0;
            while (right < S.length()) {
                if (target.containsKey(S.charAt(right))) {
                    map.put(S.charAt(right), map.getOrDefault(S.charAt(right), 0) + 1);
                }
                while (check() && left <= right) {
                    if (right - left + 1 < minLen) {
                        minLen = right - left + 1;
                        ansL = left;
                        ansR = right;
                    }
                    if (target.containsKey(S.charAt(left))) {
                        map.put(S.charAt(left), map.getOrDefault(S.charAt(left), 0) - 1);
                    }
                    left++;
                }
                right++;
            }
            return ansL == -1 ? "" : S.substring(ansL, ansR + 1);
        }

        private boolean check() {
            for (Map.Entry<Character, Integer> entry : target.entrySet()) {
                if (map.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        String S = "XDOYEZODEYXNZ";
        String T = "XYZ";
        System.out.println(new Solution().minWindow(S, T));
    }
}

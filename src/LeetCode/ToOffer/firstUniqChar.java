package LeetCode.ToOffer;
/*
面试题50. 第一个只出现一次的字符
在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。

示例:

s = "abaccdeff"
返回 "b"

s = ""
返回 " "


限制：

0 <= s 的长度 <= 50000

通过次数4,817提交次数8,161
 */


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class firstUniqChar {
    static class Solution {
        public char firstUniqChar(String s) {
            Map<Character, Integer> hashmap = new LinkedHashMap<>();
            char ans = ' ';
            for (int i = 0; i < s.length(); i++) {
                hashmap.put(s.charAt(i), hashmap.getOrDefault(s.charAt(i), 0) + 1);
            }
            for (Map.Entry<Character, Integer> entry : hashmap.entrySet()) {
                if (entry.getValue() == 1) {
                    ans = entry.getKey();
                    break;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(new Solution().firstUniqChar(scanner.nextLine()));
        }
    }
}

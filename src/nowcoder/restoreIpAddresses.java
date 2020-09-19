package nowcoder;
/*
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：14489
本题知识点： 字符串 回溯
 算法知识视频讲解
题目描述
现在有一个只包含数字的字符串，将该字符串转化成IP地址的形式，返回所有可能的情况。
例如：
给出的字符串为"25525511135",
返回["255.255.11.135", "255.255.111.35"]. (顺序没有关系)
示例1
输入
复制
"25525511135"
输出
复制
["255.255.11.135","255.255.111.35"]
 */

import java.util.ArrayList;

public class restoreIpAddresses {
    static public class Solution {
        /**
         * @param s string字符串
         * @return string字符串ArrayList
         */
        ArrayList<String> ans;

        public ArrayList<String> restoreIpAddresses(String s) {
            ans = new ArrayList<>();
            for (int i = 1; i < 4; i++) {
                dfs(s, new ArrayList<>(), i);
            }
            return ans;
        }

        private void dfs(String s, ArrayList<Integer> list, int end) {
            if (s.length() == 0 && list.size() == 4) {
                StringBuilder stringBuilder = new StringBuilder();
                for (Integer a : list) {
                    stringBuilder.append(a);
                    stringBuilder.append('.');
                }
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                String IP = stringBuilder.toString();
                if (!ans.contains(IP)) {
                    ans.add(IP);
                }
                return;
            }
            if (end > s.length()) {
                return;
            }

            int ip = mkip(s, end);

            if (ip >= 0 && ip <= 255) {
                list.add(ip);
            } else {
                return;
            }
            for (int i = 1; i < 4; i++) {
                dfs(s.substring(end), new ArrayList<>(list), i);
            }
        }

        private int mkip(String s, int end) {
            String x = s.substring(0, end);
            int ip = Integer.parseInt(x);
            if (String.valueOf(ip).length() != x.length()) {
                return -1;
            } else {
                return ip;
            }
        }
    }

    public static void main(String[] args) {
        String s = "010010";
        System.out.println(new Solution().restoreIpAddresses(s));
    }
}

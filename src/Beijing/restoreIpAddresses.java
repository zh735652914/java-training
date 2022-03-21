package Beijing;
/*
https://leetcode-cn.com/problems/restore-ip-addresses/
 */

import java.util.LinkedList;
import java.util.List;

// 写起来有点小麻烦
public class restoreIpAddresses {
    static class Solution {
        private List<String> ans;

        public List<String> restoreIpAddresses(String s) {
            ans = new LinkedList<>();
            dfs(s, new StringBuilder(), 0, 0);
            return ans;
        }

        private void dfs(String s, StringBuilder address, int index, int count) {
            if (count > 4) {
                return;
            }
            if (count == 4 && index == s.length()) {
                address.deleteCharAt(address.length() - 1);
                ans.add(String.valueOf(address));
                return;
            }
            if (index >= s.length()) {
                return;
            }
            for (int i = 1; i <= 3; i++) {
                if (index + i > s.length()) {
                    return;
                }
                String sub = s.substring(index, index + i);
                int size = address.length();
                if (isValid(sub)) {
                    address.append(sub);
                    address.append('.');
                    dfs(s, address, index + i, count + 1);
                    address.delete(size, address.length());
                }
            }
        }

        private boolean isValid(String s) {
            if (s.charAt(0) == '0' && s.length() != 1) {
                return false;
            }
            int num = Integer.parseInt(s);
            return num >= 0 && num <= 255;
        }
    }

    public static void main(String[] args) {
//        String s = "25525511135";
        String s = "0000";
        System.out.println(new Solution().restoreIpAddresses(s));
    }
}

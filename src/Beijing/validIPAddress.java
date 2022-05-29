package Beijing;
/*
https://leetcode.cn/problems/validate-ip-address/
 */

// 这题属实有点恶心
public class validIPAddress {
    static class Solution {
        public String validIPAddress(String queryIP) {
            if (queryIP.length() < 1) {
                return "Neither";
            }
            String[] ips = null;
            if (queryIP.contains(".")) {
                if (queryIP.charAt(0) == '.' || queryIP.charAt(queryIP.length() - 1) == '.') {
                    return "Neither";
                }
                ips = queryIP.split("\\.");
            } else {
                if (queryIP.charAt(0) == ':' || queryIP.charAt(queryIP.length() - 1) == ':') {
                    return "Neither";
                }
                ips = queryIP.split(":");
            }
            if (ips.length != 4 && ips.length != 8) {
                return "Neither";
            }
            if (ips.length == 4 && isIPv4(ips)) {
                return "IPv4";
            }
            if (ips.length == 8 && isIPv6(ips)) {
                return "IPv6";
            }
            return "Neither";
        }

        private boolean isIPv6(String[] ips) {
            for (String num : ips) {
                if (!ipv6Num(num)) {
                    return false;
                }
            }
            return true;
        }

        private boolean ipv6Num(String num) {
            int len = num.length();
            if (len < 1 || len > 4) {
                return false;
            }
            num = num.toLowerCase();
            for (int i = 0; i < len; i++) {
                char ch = num.charAt(i);
                if (!Character.isDigit(ch) && (ch < 'a' || ch > 'f')) {
                    return false;
                }
            }
            return true;
        }

        private boolean isIPv4(String[] ips) {
            for (String num : ips) {
                if (!ipv4Num(num)) {
                    return false;
                }
            }
            return true;
        }

        private boolean ipv4Num(String num) {
            if (num.length() < 1) {
                return false;
            }
            int x = 0;
            for (int i = 0; i < num.length(); i++) {
                char ch = num.charAt(i);
                if (!Character.isDigit(ch) || i == 0 && num.length() != 1 && ch == '0') {
                    return false;
                }
                x *= 10;
                x += ch - '0';
            }
            return x >= 0 && x <= 255;
        }
    }

    public static void main(String[] args) {
        String queryIP = "2001:0db8:85a3:0:0:8A2E:0370:7334:";
        System.out.println(new Solution().validIPAddress(queryIP));
    }
}

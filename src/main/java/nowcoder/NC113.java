package nowcoder;
/*
 牛客题霸-名企高频面试题
验证IP地址
时间限制：C/C++ 1秒，其他语言2秒 空间限制：C/C++ 32M，其他语言64M 热度指数：1160
本题知识点： 字符串
 算法知识视频讲解
题目描述
编写一个函数来验证输入的字符串是否是有效的 IPv4 或 IPv6 地址

IPv4 地址由十进制数和点来表示，每个地址包含4个十进制数，其范围为 0 - 255， 用(".")分割。比如，172.16.254.1；
同时，IPv4 地址内的数不会以 0 开头。比如，地址 172.16.254.01 是不合法的。

IPv6 地址由8组16进制的数字来表示，每组表示 16 比特。这些组数字通过 (":")分割。比如,  2001:0db8:85a3:0000:0000:8a2e:0370:7334 是一个有效的地址。
而且，我们可以加入一些以 0 开头的数字，字母可以使用大写，也可以是小写。所以， 2001:db8:85a3:0:0:8A2E:0370:7334 也是一个有效的 IPv6 address地址
(即，忽略 0 开头，忽略大小写)。

然而，我们不能因为某个组的值为 0，而使用一个空的组，以至于出现 (::) 的情况。 比如， 2001:0db8:85a3::8A2E:0370:7334 是无效的 IPv6 地址。
同时，在 IPv6 地址中，多余的 0 也是不被允许的。比如， 02001:0db8:85a3:0000:0000:8a2e:0370:7334 是无效的。

说明: 你可以认为给定的字符串里没有空格或者其他特殊字符。
示例1
输入
复制
"172.16.254.1"
输出
复制
"IPv4"
说明
这是一个有效的 IPv4 地址, 所以返回 "IPv4"
示例2
输入
复制
"2001:0db8:85a3:0:0:8A2E:0370:7334"
输出
复制
"IPv6"
说明
这是一个有效的 IPv6 地址, 所以返回 "IPv6"
示例3
输入
复制
"256.256.256.256"
输出
复制
"Neither"
说明
这个地址既不是 IPv4 也不是 IPv6 地址
备注:
ip地址的类型，可能为
IPv4,   IPv6,   Neither
 */

public class NC113 {
    static public class Solution {
        /**
         * 验证IP地址
         *
         * @param IP string字符串 一个IP地址字符串
         * @return string字符串
         */
        public String solve(String IP) {
            if (IP.contains(":")) {
                if (isIPv6(IP)) {
                    return "IPv6";
                } else {
                    return "Neither";
                }
            } else {
                if (isIPv4(IP)) {
                    return "IPv4";
                } else {
                    return "Neither";
                }
            }
        }

        private boolean isIPv6(String IP) {
            String[] nums = IP.split(":");
            if (nums.length != 8) {
                return false;
            }
            for (String num : nums) {
                if (num.length() == 0) {
                    return false;
                }
                int index = 0;
                while (index < num.length()) {
                    if (num.charAt(index) != '0') {
                        break;
                    }
                    index++;
                }
                if (index == num.length() && num.length() > 1) {
                    return false;
                }
            }
            return true;
        }

        private boolean isIPv4(String IP) {
            String[] nums = IP.split("\\.");
            if (nums.length != 4) {
                return false;
            }
            for (String num : nums) {
                int x = Integer.parseInt(num);
                if (x == 0 && num.length() != 1) {
                    return false;
                }
                if (x < 0 || x > 255) {
                    return false;
                }
                if (x != 0 && num.charAt(0) == '0') {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        String IP = "172.16.254.1";
        System.out.println(new Solution().solve(IP));
    }
}

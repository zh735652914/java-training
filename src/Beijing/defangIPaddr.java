package Beijing;
/*
https://leetcode.cn/problems/defanging-an-ip-address/
 */

// 这题很没意思
public class defangIPaddr {
    static class Solution {
        public String defangIPaddr(String address) {
            return address.replace(".", "[.]");
        }
    }

    public static void main(String[] args) {
        String address = "1.1.1.1";
        System.out.println(new Solution().defangIPaddr(address));
    }
}

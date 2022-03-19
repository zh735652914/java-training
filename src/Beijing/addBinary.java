package Beijing;
/*
https://leetcode-cn.com/problems/add-binary/
 */

public class addBinary {
    // 这题有点麻烦
    static class Solution {
        public String addBinary(String a, String b) {
            StringBuilder stringBuilder = new StringBuilder();
            int n = Math.max(a.length(), b.length());
            int carry = 0;
            for (int i = 0; i < n; i++) {
                int x = i < a.length() ? a.charAt(a.length() - 1 - i) - '0' : 0;
                int y = i < b.length() ? b.charAt(b.length() - 1 - i) - '0' : 0;
                int sum = x + y + carry;
                carry = sum >> 1;
                stringBuilder.append(sum - (carry << 1));
            }
            if (carry >= 1) {
                stringBuilder.append(1);
            }
            return stringBuilder.reverse().toString();
        }
    }

    public static void main(String[] args) {
        String a = "11", b = "1";
        System.out.println(new Solution().addBinary(a, b));
    }
}

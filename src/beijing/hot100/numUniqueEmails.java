package beijing.hot100;
/*
https://leetcode.cn/problems/unique-email-addresses/
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class numUniqueEmails {
    // 官方写的更简洁
    static class Solution {
        public int numUniqueEmails(String[] emails) {
            Set<String> set = new HashSet<>();
            for (String email : emails) {
                int pos = email.indexOf('@');
                String local = email.substring(0, pos).split("\\+")[0];
                local = local.replace(".", "");
                set.add(local + email.substring(pos));
            }
            return set.size();
        }
    }

    static class Solution0 {
        public int numUniqueEmails(String[] emails) {
            Map<String, Set<String>> map = new HashMap<>();
            for (String email : emails) {
                String[] s = email.split("@");
                String domain = s[1];
                String name = getName(s[0]);
                if (!map.containsKey(domain)) {
                    Set<String> set = new HashSet<>();
                    set.add(name);
                    map.put(domain, set);
                } else {
                    map.get(domain).add(name);
                }
            }
            int count = 0;
            for (String key : map.keySet()) {
                count += map.get(key).size();
            }
            return count;
        }

        private String getName(String email) {
            if (!email.contains("+") && !email.contains(".")) {
                return email;
            }
            StringBuilder name = new StringBuilder();
            for (int i = 0; i < email.length(); i++) {
                if (email.charAt(i) == '.') {
                    continue;
                }
                if (email.charAt(i) == '+') {
                    break;
                }
                name.append(email.charAt(i));
            }
            return name.toString();
        }
    }

    public static void main(String[] args) {
        String[] emails = {"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};
        System.out.println(new Solution().numUniqueEmails(emails));
    }
}

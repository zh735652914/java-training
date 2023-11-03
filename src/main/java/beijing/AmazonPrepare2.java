package beijing;
/*
https://blog.csdn.net/weixin_39881802/article/details/111538350
 */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AmazonPrepare2 {
    // 这个是自己写的
    static class Solution0 {
        class Node {
            char value;
            List<Character> next;

            Node(char value) {
                this.value = value;
                next = new ArrayList<>();
            }
        }

        private Map<Character, Node> map;

        public List<String> solution(String baseRules, String checkingRules) {
            String[] bases = baseRules.split(" ");
            String[] checks = checkingRules.split(" ");

            map = new HashMap<>();
            for (String base : bases) {
                String[] s = base.split(">");
                char right = s[1].charAt(0);
                String[] left = s[0].split(",");
                if (!map.containsKey(right)) {
                    Node node = new Node(right);
                    for (String L : left) {
                        node.next.add(L.charAt(0));
                    }
                    map.put(right, node);
                } else {
                    Node node = map.get(right);
                    for (String L : left) {
                        if (!node.next.contains(L.charAt(0))) {
                            node.next.add(L.charAt(0));
                        }
                    }
                }
            }

            List<String> ans = new ArrayList<>();

            for (String check : checks) {
                String[] s = check.split(">");
                char right = s[1].charAt(0);
                String[] left = s[0].split(",");
                boolean canCheck = true;
                for (String L : left) {
                    canCheck = canCheck && isCheck(L.charAt(0), right);
                }
                ans.add(canCheck ? "true" : "false");
            }
            return ans;
        }

        private boolean isCheck(char left, char right) {
            if (!map.containsKey(right) || map.get(right).next.size() == 0) {
                return false;
            }
            List<Character> next = map.get(right).next;
            if (next.contains(left)) {
                return true;
            }
            boolean canCheck = false;
            for (char ch : next) {
                canCheck = canCheck || isCheck(left, ch);
            }
            return canCheck;
        }
    }


    public static void main(String[] args) {
        String baseRules = "A>B B>C";
        String checkingRules = "A>C";
        System.out.println(new Solution0().solution(baseRules, checkingRules));
    }
}

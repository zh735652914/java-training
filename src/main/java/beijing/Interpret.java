package beijing;
/*
https://leetcode.cn/problems/goal-parser-interpretation/
 */

public class Interpret {

    // 都很简单
    static class Solution {
        public String interpret(String command) {
            int len = command.length();
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < len; i++) {
                if (command.charAt(i) == 'G') {
                    stringBuilder.append('G');
                } else if (command.charAt(i) == '(') {
                    if (i + 1 < len && command.charAt(i + 1) == ')') {
                        stringBuilder.append('o');
                        i++;
                    } else {
                        stringBuilder.append("al");
                        i += 2;
                    }
                }
            }
            return stringBuilder.toString();
        }
    }

    // 如果用replace就很简单
    static class Solution0 {
        public String interpret(String command) {
            command = command.replace("()", "o");
            return command.replace("(al)", "al");
        }
    }

    public static void main(String[] args) {
        String command = "G()(al)";
        System.out.println(new Solution().interpret(command));
    }
}

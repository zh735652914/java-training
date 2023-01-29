package beijing;

import java.util.Stack;

/*
https://leetcode-cn.com/problems/simplify-path/
 */
public class simplifyPath {
    static class Solution {
        public String simplifyPath(String path) {
            String[] file = path.split("/");
            Stack<String> stack = new Stack<>();
            for (int i = 0; i < file.length; i++) {
                if (stack.isEmpty() && (file[i].equals(".") || file[i].equals(".."))) {
                    continue;
                }
                if (!stack.isEmpty() && file[i].equals("..")) {
                    stack.pop();
                    continue;
                }
                if (file[i].equals(".") || file[i].length() == 0) {
                    continue;
                }
                stack.push(file[i]);
            }
            if (stack.isEmpty()) {
                return "/";
            }
            StringBuilder stringBuilder = new StringBuilder();
            Stack<String> tmp = new Stack<>();
            while (!stack.isEmpty()) {
                tmp.push(stack.pop());
            }
            while (!tmp.isEmpty()) {
                stringBuilder.append('/');
                stringBuilder.append(tmp.pop());
            }
            return stringBuilder.toString();
        }
    }

    public static void main(String[] args) {
        String path = "/home/...";
        System.out.println(new Solution().simplifyPath(path));
    }
}

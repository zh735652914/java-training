package Interview;


import java.util.Scanner;
import java.util.Stack;

public class sunfeng_bishi0 {
    public void solution(String x) {
        System.out.println(backtrack(x));
    }

    private String backtrack(String x) {
        int begin = 0, end = 0;
        boolean flag = false;
        for (int i = 0; i < x.length() - 1; i++) {
            if (x.charAt(i) == x.charAt(i + 1)) {
                begin = i;
                end = i;
                flag = true;
            }
            while (x.charAt(i) == x.charAt(i + 1) && i < x.length() - 1) {
                i++;
            }
            end = i;
        }
        if (flag) {
            return x;
        } else {
            return backtrack(x.substring(0, begin) + x.substring(end));
        }
    }

    public void solution0(String x) {
        Stack<Character> stack = new Stack<>();
//        char last = ' ';
//        for (int i = 0; i < x.length(); i++) {
//            if (x.charAt(i) == last && stack.isEmpty()) {
//                continue;
//            }
//            if (!stack.isEmpty()) {
//                if (stack.peek() == x.charAt(i)) {
//                    stack.pop();
//                    last = x.charAt(i);
//                    continue;
//                }
//            }
//            last = x.charAt(i);
//            stack.push(x.charAt(i));
//        }

        stack = dfs(x, 0, stack);
        if (stack.isEmpty()) {
            System.out.println("empty");
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            for (Character character : stack) {
                stringBuilder.append(character);
            }
            System.out.println(stringBuilder.toString());
        }
    }

    private Stack<Character> dfs(String x, int index, Stack<Character> stack) {
        if (index >= x.length()) {
            return stack;
        }
        if (stack.isEmpty()) {
            stack.push(x.charAt(index));
            return dfs(x, index + 1, stack);
        } else {
            if (stack.peek() == x.charAt(index)) {
                stack.push(x.charAt(index));
                Stack<Character> A = dfs(x, index + 1, stack);
                stack.pop();

                Stack<Character> tmp = stack;
                while (!stack.isEmpty()) {
                    if (stack.peek() == x.charAt(index)) {
                        stack.pop();
                    }
                }
                Stack<Character> B = dfs(x, index + 1, stack);
                return A.size() < B.size() ? A : B;
            } else {
                stack.push(x.charAt(index));
                return dfs(x, index + 1, stack);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            new sunfeng_bishi0().solution(scanner.nextLine());
        }
    }
}

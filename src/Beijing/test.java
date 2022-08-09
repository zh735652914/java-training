package Beijing;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        System.out.println("输入题目名");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        String[] words = name.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < words.length; i++) {
            if (words[i].length() < 1) {    // 如果为空
                continue;
            }
            stringBuilder.append(words[i]);
        }
        stringBuilder.append('_');
        stringBuilder.append(words[0], 0, words[0].length() - 1);
        char first = stringBuilder.charAt(0);
        first = Character.toLowerCase(first);
        stringBuilder.replace(0, 1, String.valueOf(first));
        stringBuilder.append("_topInterviewList");
        System.out.println(stringBuilder);
    }
}

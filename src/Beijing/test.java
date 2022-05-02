package Beijing;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        System.out.println("输入题目名");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        String[] words = name.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (String word : words) {
            if (word.length() < 1) {
                continue;
            }
            stringBuilder.append(word);
        }
        char first = stringBuilder.charAt(0);
        first = Character.toLowerCase(first);
        stringBuilder.replace(0, 1, String.valueOf(first));
        System.out.println(stringBuilder);
    }
}

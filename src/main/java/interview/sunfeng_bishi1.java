package interview;

import java.util.Scanner;

public class sunfeng_bishi1 {
    public void Solution(String x) {
        x = x.toLowerCase();
        String[] words = x.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (String word : words) {
            stringBuilder.append(word);
        }
        x = stringBuilder.toString();
        int ans = 0;
        for (int i = 0; i < x.length() - 4; i++) {
            if (x.charAt(i) == 'a' && isMatch(x.substring(i + 1, i + 5))) {
                ans++;
            }
        }
        System.out.println(ans);
    }

    private boolean isMatch(String x) {
        return x.equals("pple");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            new sunfeng_bishi1().Solution(scanner.nextLine());
        }
    }
}

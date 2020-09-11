package Interview;

import java.util.Scanner;

public class xiaomi_bishi {
    private void solution(String[] input) {
        for (String x : input) {
            if (x.length() < 8 || x.length() > 120) {
                System.out.println(1);
            } else if (!isMatch(x)) {
                System.out.println(2);
            } else {
                System.out.println(0);
            }
        }
    }

    private boolean isMatch(String x) {
        boolean num_flag = false, up_flag = false, low_flag = false, fuhao_flag = false;
        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) >= '0' && x.charAt(i) <= '9') {
                num_flag = true;
            } else if (x.charAt(i) >= 'a' && x.charAt(i) <= 'z') {
                low_flag = true;
            } else if (x.charAt(i) >= 'A' && x.charAt(i) <= 'Z') {
                up_flag = true;
            } else if (x.charAt(i) - '0' >= -16 && x.charAt(i) - '0' <= 78) {
                fuhao_flag = true;
            }
        }

        return num_flag && up_flag && low_flag && fuhao_flag;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] input = scanner.nextLine().split(" ");
            new xiaomi_bishi().solution(input);
        }
    }
}

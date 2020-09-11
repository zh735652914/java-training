package Interview;

import java.util.Scanner;

public class sanliulin_bishi2 {
    private void solution(String input) {
        if (input.length() < 8 || !isMatch(input)) {
            System.out.println("Irregular password");
        } else {
            System.out.println("Ok");
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
            String input = scanner.nextLine();
            new sanliulin_bishi2().solution(input);
        }
    }
}

package Interview;

import java.util.Scanner;

public class jingdong_bishi0 {
    public void solution(String s) {
        for (int i = 0; i < s.length() - 4; i++) {
            int res = isDit(s, i);
            if (res == -2) {
                int dig = Integer.parseInt(s.substring(i, i + 4));
                if (dig >= 1000 && dig <= 3999) {
                    System.out.print(dig + " ");
                }
                i = i + 3;
            } else if (res >= 0) {
                i = res;
            } else {
                break;
            }
        }
    }

    //-1为不对，-2为正确，>0为不是数字
    private int isDit(String s, int index) {
        if (index >= s.length() - 4) {
            return -1;
        }

        int count = 0;
        int next_start = index;
        for (int i = 0; i + index < s.length(); i++) {
            if (s.charAt(index + i) >= '0' && s.charAt(index + i) <= '9') {
                count++;
            } else {
                break;
            }
            next_start = index + i;
        }

        if (count == 4) {
            return -2;
        } else {
            return next_start;
        }
    }

//    public void solution(String s) {
//        for (int i = 0; i < s.length() - 4; i++) {
//            if (isDit(s, i)) {
//                int dig = Integer.parseInt(s.substring(i, i + 4));
//                if (dig >= 1000 && dig <= 3999) {
//                    System.out.print(dig + " ");
//                }
//            }
//        }
//    }

//    private boolean isDit(String s, int index) {
//        if (index >= s.length() - 4) {
//            return false;
//        }
//        for (int i = 0; i < 4; i++) {
//            if (s.charAt(index + i) < '0' || s.charAt(index + i) > '9') {
//                return false;
//            }
//        }
//        return true;
//    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            new jingdong_bishi0().solution(scanner.nextLine());
        }
    }
}

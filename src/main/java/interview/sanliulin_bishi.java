package interview;

import java.util.Scanner;

//过了82%
class backup {
//    import java.util.Scanner;
//
//    public class Main {
//        public void solution(int n, int m, int[] A, int[] B) {
//            boolean[] people = new boolean[n + 1];
//
//            for (int i = 0; i < A.length; i++) {
//
//                if (!people[A[i]]) {
//                    people[A[i]] = true;
//                }
//
//            }
//            if (B[0] == 1 && B[B.length - 1] == 0 && A[0] == A[A.length - 1]) {
//                people[A[0]] = false;
//            }
//
//            for (int i = 1; i < people.length; i++) {
//                if (!people[i]) {
//                    System.out.print(i + " ");
//                }
//            }
//        }
//
//        public static void main(String[] args) {
//            Scanner scanner = new Scanner(System.in);
//            int n = scanner.nextInt();
//            int m = scanner.nextInt();
//            int[] A = new int[m];
//            int[] B = new int[m];
//            for (int i = 0; i < m; i++) {
//                A[i] = scanner.nextInt();
//                B[i] = scanner.nextInt();
//            }
//            new Main().solution(n, m, A, B);
//        }
//    }
}

public class sanliulin_bishi {
    public void solution(int n, int m, int[] A, int[] B) {
        boolean[] people = new boolean[n + 1];
        boolean first = false;
        int firstMan = -1;
        if (B[0] == 1) {
            first = true;
            firstMan = A[0];
        }
        for (int i = 0; i < A.length; i++) {
            if (!people[A[i]]) {
                people[A[i]] = true;
            }
            if (i != 0 && first && A[i] == firstMan && B[i] == 0) {
                first = false;
            }
        }
        if (B[0] == 1 && B[B.length - 1] == 0 && A[0] == A[A.length - 1]) {
            people[A[0]] = false;
        }
//        if (B[0] == 1) {
//            people[A[0]] = false;
//        }
        if (first) {
            people[firstMan] = false;
        }
        for (int i = 1; i < people.length; i++) {
            if (!people[i]) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] A = new int[m];
        int[] B = new int[m];
        for (int i = 0; i < m; i++) {
            A[i] = scanner.nextInt();
            B[i] = scanner.nextInt();
        }
        new sanliulin_bishi().solution(n, m, A, B);
    }
}

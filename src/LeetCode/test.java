package LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZhouHao on 2019/4/3.
 */


public class test {

//    public static void main(String[] args) {
//        long a = 20, b = 40;
//        System.out.println(gcd(a, b));
//    }

    //    static long A = new test().gcd(6, 3);
//
//    int A, B;
//    public static long gcd(long a, long b) {
//        while (b > 0) {
//            long c = a;
//            a = b;
//            b = c % b;
//        }
//        System.out.println(a);
//        return a;
//    }
//
//    public static void testA() {
//        test obj = new test();
//        obj.A
//    }
    public Object instance = null;
    private static final int _1MB = 1024 * 1024;
    private byte[] bogSize = new byte[2 * _1MB];

    @Test
    public void testGC() {
        test objA = new test();
        test objB = new test();
        objA.instance = objB;
        objB.instance = objA;
        objA = null;
        objB = null;

        System.gc();
    }

    @Test
    public void testHashCode() {
        List<Integer> A = new ArrayList<>();
        A.add(123);
        System.out.println(A.hashCode());
    }
}
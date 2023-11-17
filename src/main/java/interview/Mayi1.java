package interview;

/**
 * @author zhouhao
 * @date 2023/11/17 12:52
 * 两个线程交替打印1-100的整数，一个打印奇数，一个打印偶数，要求输出结果有序
 */
public class Mayi1 {
    private static volatile Integer counter = 1;
    private static volatile boolean flag = true;

    public void print() {

        Thread odd = new Thread(() -> {
            while (counter <= 100) {
                if (flag) {
                    System.out.println(Thread.currentThread().getName() + " " + counter++);
                    flag = false;
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "odd");

        Thread even = new Thread(() -> {
            while (counter <= 100) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (!flag) {
                    System.out.println(Thread.currentThread().getName() + " " + counter++);
                    flag = true;
                }

            }
        }, "even");
        odd.start();
        even.start();
    }

    public static void main(String[] args) {
        new Mayi1().print();
    }
}

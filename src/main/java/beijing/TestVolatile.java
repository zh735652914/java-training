package beijing;

/**
 * @author zhouhao
 * @date 2023/4/28 16:03
 */
public class TestVolatile {
    private static volatile int x = 1;

    static class MyThread extends Thread {
        /**
         * If this thread was constructed using a separate
         * {@code Runnable} run object, then that
         * {@code Runnable} object's {@code run} method is called;
         * otherwise, this method does nothing and returns.
         * <p>
         * Subclasses of {@code Thread} should override this method.
         *
         * @see #start()
         * @see #stop()
         */
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                x++;
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new MyThread();
        Thread t2 = new MyThread();
        t1.start();
        t2.start();
        System.out.println(x);
    }
}

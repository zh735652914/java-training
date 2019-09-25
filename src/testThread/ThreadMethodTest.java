package testThread;

class TestThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
//            if (i > 50) {
//                yield();
//            }
            if (i % 2 != 0) {
//                try {
//                    sleep(500);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println(Thread.currentThread().getName() + "\tPriority:" + getPriority() + "\t|" + i);
            }

        }
    }

    public TestThread(String name) {
        super(name);
    }
}

public class ThreadMethodTest {
    public static void main(String[] args) {

        TestThread h1 = new TestThread("线程1");
//        h1.setName("线程一");
        h1.start();
        Thread.currentThread().setName("主线程");
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + "\tThis is main\t" + "\tPriority:" + Thread.currentThread().getPriority() + "\t|" + i);
            }
//            if (i == 30) {
//                try {
//                    h1.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
        }
    }
}

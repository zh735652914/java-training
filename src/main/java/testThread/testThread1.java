package testThread;

class myThread extends Thread {
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + "  This is myThread" + i);
            }
        }
    }
}

public class testThread1 {
    public static void main(String[] args) {
        myThread my = new myThread();
//        myThread my1 = new myThread();
        my.start();
//        my1.start();
//        my.run();
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 != 0) {
                        System.out.println(Thread.currentThread().getName() + "  This is myThread2   " + i);
                    }
                }
            }
        }.start();
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + "   This is main()~~~~~~~~~~" + i);
            }
        }
    }
}

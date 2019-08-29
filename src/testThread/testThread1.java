package testThread;

class myThread extends Thread {
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println("This is myThread" + i);
            }
        }
    }
}

public class testThread1 {
    public static void main(String[] args) {
        myThread my = new myThread();
        my.start();
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println("This is main()~~~~~~~~~~" + i);
            }
        }
    }
}

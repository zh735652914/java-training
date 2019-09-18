package testThread;

/*
线程不安全，所以会输出多个100
 */
class Window extends Thread {
    //若没有static，则三个线程的输出都有1-100
    private static int tickets = 100;

    @Override
    public void run() {
        while (true) {
            if (tickets > 0) {
                System.out.println(getName() + ":买票，票号为：" + tickets);
                tickets--;
            } else {
                break;
            }
        }
    }
}

public class WindowTest {
    public static void main(String[] args) {
        Window T1 = new Window();
        Window T2 = new Window();
        Window T3 = new Window();

        T1.start();
        T2.start();
        T3.start();
    }
}

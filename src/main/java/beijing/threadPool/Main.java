package beijing.threadPool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.IntStream;

/**
 * @author zhouhao
 * @date 2023/10/27 13:48
 */
public class Main {
    public static void main(String[] args) {
        MyThreadPool pool = new MyThreadPool(new LinkedBlockingQueue<>(10), 3);
        IntStream.rangeClosed(1, 5).forEach((i) -> {
            try {
                pool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "测试");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}

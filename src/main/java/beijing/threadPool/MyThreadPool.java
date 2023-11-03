package beijing.threadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.stream.IntStream;

/**
 * @author zhouhao
 * @date 2023/10/27 13:22
 */
public class MyThreadPool {
    BlockingQueue<Runnable> taskQueue;  //存放任务的阻塞队列
    List<MyThread> threads; //线程列表

    MyThreadPool(BlockingQueue<Runnable> taskQueue, int threadSize) {
        this.taskQueue = taskQueue;
        threads = new ArrayList<>(threadSize);
        // 初始化线程，并定义名称
        IntStream.rangeClosed(1, threadSize).forEach((i) -> {
            MyThread thread = new MyThread("my-task-thread-" + i);
            thread.start();
            threads.add(thread);
        });
    }

    //提交任务只是往任务队列里面塞任务
    public void execute(Runnable task) throws InterruptedException {
        taskQueue.put(task);
    }

    class MyThread extends Thread { //自定义一个线程
        public MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            while (true) { //死循环
                Runnable task = null;
                try {
                    task = taskQueue.take(); //不断从任务队列获取任务
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                task.run(); //执行
            }
        }
    }
}

package beijing.threadPool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * @author zhouhao
 * @date 2023/11/4 15:21
 * <p>
 * 单元测试是不支持多线程的，主线程结束之后，不管子线程有没有结束，都会强制退出。但是我们可以通过控制主线程结束的时间来做多线程测试.
 * <p>
 * 在JUnit的@Test方法中启用多线程，新启动的线程会随着@Test主线程的死亡而死亡！导致没有任何输出
 * <p>
 * https://developer.huawei.com/consumer/cn/forum/topic/0202438478344770295
 */

@Slf4j
public class ThreadPoolCreat {

    /**
     *
     * 线程池四种创建方式
     * Java通过Executors（jdk1.5并发包）提供四种线程池，分别为：
     *  newCachedThreadPool创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
     *  newFixedThreadPool 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
     *  newScheduledThreadPool 创建一个定长线程池，支持定时及周期性任务执行。
     *  newSingleThreadExecutor 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
     *
     * ThreadPoolExecutor,推荐用这个创建线程池
     * https://developer.huawei.com/consumer/cn/forum/topic/0202438478344770295
     *
     * 不建议使用Executors的最重要的原因是：Executors提供的很多方法默认使用的都是无界的LinkedBlockingQueue，高负载情境下，
     * 无界队列很容易导致OOM，而OOM会导致所有请求都无法处理，这是致命问题。所以强烈建议使用有界队列。
     * 注：LinkedBlockingQueue是有界队列，但是不设置大小的话，就默认为Integer.MAX_VALUE，相当于无界队列了。
     *
     **/


    /**
     * newCachedThreadPool
     * 创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
     */
    @Test
    public void testNewCachedThreadPool() throws InterruptedException {
        //1.创建可缓存的线程池，可重复利用
        ExecutorService newExecutorService = Executors.newCachedThreadPool();
        //创建了10个线程
        for (int i = 0; i < 10; i++) {
            int temp = i;
            newExecutorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("threadName: " + Thread.currentThread().getName() + ", i = " + temp);
                }
            });
        }

        // 测试线程池的方案

        // 方法一
//        newExecutorService.shutdown();
//        CountDownLatch countDownlatch = new CountDownLatch(10);//使用计数器
//        try {
//            // 当计数为0时结束阻塞，所有线程countDown()都执行之后才会释放当前线程,程序才能继续往后执行
//            countDownlatch.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


        // 方法二
//        if (!newExecutorService.isShutdown()){
//            Thread.currentThread().join();
//        }

        // 方法三
        Thread.sleep(1000);
    }

    /**
     * newFixedThreadPool 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
     *
     * @throws InterruptedException
     */
    @Test
    public void testNewFixedThreadPool() throws InterruptedException {
        //1.创建可固定长度的线程池
        ExecutorService newExecutorService = Executors.newFixedThreadPool(5);
        //创建了10个线程
        for (int i = 0; i < 10; i++) {
            int temp = i;
            newExecutorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("threadName: " + Thread.currentThread().getName() + " , i = " + temp);
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }
        System.out.println("主线程开始休眠");
        Thread.sleep(10000);
        System.out.println("主线程执行完");
    }

    /**
     * newScheduledThreadPool 创建一个定长线程池，支持定时及周期性任务执行。
     *
     * @throws InterruptedException
     */
    @Test
    public void testNewScheduledThreadPool() throws InterruptedException {
        //1.创建可定时线程池
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 10; i++) {
            final int temp = i;
            newScheduledThreadPool.schedule(new Runnable() {
                public void run() {
                    System.out.println("threadName: " + Thread.currentThread().getName() + " , i = " + temp);
                }
            }, 3, TimeUnit.SECONDS);
        }

        Thread.sleep(5000);
    }

    /**
     * newSingleThreadExecutor
     * 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行
     *
     * @throws InterruptedException
     */
    @Test
    public void testNewSingleThreadExecutor() throws InterruptedException {
        // 1.创建单线程
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int temp = i;
            newSingleThreadExecutor.execute(new Runnable() {

                @Override
                public void run() {
                    System.out.println("threadName: " + Thread.currentThread().getName() + " , i = " + temp);
                    try {
                        Thread.sleep(200);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        newSingleThreadExecutor.shutdown();
        Thread.sleep(5000);
    }

    /**
     * ThreadPoolExecutor,推荐用这个创建线程池
     *
     * @throws InterruptedException
     */
    @Test
    public void testThreadPoolExecutor() throws InterruptedException {

        // 使用Google开源框架 guava 提供的 ThreadFactoryBuilder 快速给线程池里的线程设置有意义的名字。
        ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNameFormat("自定义的子线程" + "-%d")
                .setDaemon(true).build();

        // 创建线程池
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(5, 10, 100,
                TimeUnit.SECONDS, new LinkedBlockingQueue<>(10), threadFactory);

        log.info("线程池的核心线程数：" + threadPool.getPoolSize());

        // 执行任务
        for (int i = 0; i < 10; i++) {
            final int index = i;
            threadPool.execute(() -> {
                log.info(index + " 被执行 , 线程名:" + Thread.currentThread().getName());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            log.info("i= " + i + " quee " + threadPool.getQueue().size());
        }

        log.info("主线程开始休眠");
        Thread.sleep(10000);
        log.info("线程池的核心线程数：" + threadPool.getPoolSize());
        log.info("主线程执行完");
    }

}

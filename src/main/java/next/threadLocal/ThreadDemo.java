package next.threadLocal;

import org.junit.Test;

/**
 * @author zhouhao
 * @date 2025/3/30 16:53
 */
public class ThreadDemo {
    public static final ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<>();

    @Test
    public void test() throws InterruptedException {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("main 2");

        THREAD_LOCAL.set("test1");
        System.out.println("Thread-0线程执行之前，" + Thread.currentThread().getName() + "线程取到的值：" + THREAD_LOCAL.get());
        System.out.println("Thread-0线程执行之前，" + Thread.currentThread().getName() + "线程取到的第二个值：" + threadLocal.get());
        System.out.println();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "新的线程取到的值： " + THREAD_LOCAL.get());
                THREAD_LOCAL.set("test2");
                System.out.println("重新设置之后，" + Thread.currentThread().getName() + "线程取到的值为：" + THREAD_LOCAL.get());
                System.out.println(Thread.currentThread().getName() + "线程执行结束");
                System.out.println();
            }
        }).start();
        Thread.sleep(1000L);
        System.out.println("Thread-0线程执行之后，" + Thread.currentThread().getName() + "线程取到的值：" + THREAD_LOCAL.get());
    }
}

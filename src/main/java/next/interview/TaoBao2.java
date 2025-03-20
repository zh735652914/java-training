package next.interview;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouhao
 * @date 2025/3/20 21:54
 */
public class TaoBao2 {
    private final List<Character> container = new ArrayList<>();
    private boolean thread1On = true;

    public void func(String a, String b) {

        // 线程1将字符串a每隔1s挨个添加到容器中
        Thread thread1 = new Thread(() -> {
            for (char c : a.toCharArray()) {
                synchronized (container) {
                    while (!thread1On) {
                        try {
                            container.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    container.add(c);
                    thread1On = false;
                    container.notifyAll();
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        // 线程2将字符串b每隔1s挨个添加到容器中
        Thread thread2 = new Thread(() -> {
            for (char c : b.toCharArray()) {
                synchronized (container) {
                    while (thread1On) {
                        try {
                            container.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    container.add(c);
                    thread1On = true;
                    container.notifyAll();
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });


        // 监听容器变化，输出容器元素
        Thread thread3 = new Thread(() -> {
            StringBuilder result = new StringBuilder();
            int previousSize = 0;
            while (true) {
                synchronized (container) {
                    if (container.size() > previousSize) {
                        for (int i = previousSize; i < container.size(); i++) {
                            result.append(container.get(i));
                        }
                        previousSize = container.size();
                        System.out.println(result);
                    }
                    if (previousSize == a.length() + b.length()) {
                        break;
                    }
                    try {
                        container.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Test
    public void test() {
        String a = "hloaiaa";
        String b = "el,lbb";
        func(a, b);
    }
}

package beijing.designpattern.singleton;

/**
 * 双重校验，可以延迟实例化，以及线程安全
 *
 * @author zhouhao
 * @date 2023/1/30 16:08
 */
public class Singleton2 {
    private static Singleton2 instance;
    public int num = 3;

    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        if (instance == null) {
            synchronized (Singleton2.class) {
                if (instance == null) {
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }
}

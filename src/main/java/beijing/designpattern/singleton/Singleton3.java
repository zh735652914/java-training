package beijing.designpattern.singleton;

/**
 * 内部类，可以延迟实例化，以及线程安全
 * 静态内部类方式在Singleton类被装载时并不会立即实例化，而是在需要时实例化
 *
 * @author zhouhao
 * @date 2023/1/30 16:14
 */
public class Singleton3 {
    public int num = 3;

    private Singleton3() {
    }

    private static class SingletonHolder {
        private static final Singleton3 instance = new Singleton3();
    }

    public static Singleton3 getInstance() {
        return SingletonHolder.instance;
    }
}

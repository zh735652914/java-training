package beijing.designpattern.singleton;

/**
 * 普通的单例模式，没有延迟实例化，在类加载的时候就实例化了
 *
 * @author zhouhao
 * @date 2023/1/30 14:45
 */
public class Singleton {
    private static final Singleton singleton = new Singleton();
    public int num = 1;

    private Singleton() {
    }

    public static Singleton getInstance() {
        return singleton;
    }
}

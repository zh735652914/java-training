package beijing.designpattern.singleton;

/**
 * @author zhouhao
 * @date 2023/1/30 16:02
 */
public class TestMain {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton.num);
        Singleton singleton1 = Singleton.getInstance();
        singleton1.num = 2;
        System.out.println(singleton.num);

        Singleton2 singleton2 = Singleton2.getInstance();
        System.out.println(singleton2.num);
        Singleton2 singleton21 = Singleton2.getInstance();
        singleton21.num = 4;
        System.out.println(singleton2.num);

        Singleton3 singleton3 = Singleton3.getInstance();
        System.out.println(singleton3.num);
        Singleton3 singleton31 = Singleton3.getInstance();
        singleton31.num = 4;
        System.out.println(singleton3.num);
    }
}

package testThread;

/**
 * @author zhouhao
 * @date 2023/6/5 22:00
 */
public class Son extends Father {
    public static String name = getName();

    public String address = getAddress();

    {
        System.out.println("*************子类构造代码块************");
    }

    static {
        System.out.println("*************子类静态代码块************");
    }

    static class InClass {
        public static String getName() {
            System.out.println("*************子类静态【内部类】的静态成员变量************");
            return null;
        }
    }

    public Son() {
        System.out.println("*************子类构造方法************");
    }

    public static String getName() {
        System.out.println("*************子类静态成员变量************");
        return null;
    }

    public String getAddress() {
        System.out.println("*************子类普通成员变量************");
        return null;
    }
}

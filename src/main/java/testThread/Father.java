package testThread;

/**
 * @author zhouhao
 * @date 2023/6/5 21:59
 */
public class Father {
    private static final String name = getName();

    private final String address = getAddressParam();

    {
        System.out.println("*************父类构造代码块************");
    }

    static {
        System.out.println("*************父类静态代码块************");
    }

    static class InClass {
        public static String getName() {
            System.out.println("*************父类静态【内部类】的静态成员变量************");
            return null;
        }
    }

    public Father() {
        System.out.println("*************父类构造方法************");
    }

    public static String getName() {
        System.out.println("*************父类静态成员变量************");
        return null;
    }

    public String getAddressParam() {
        System.out.println("*************父类普通成员变量************");
        return null;
    }
}

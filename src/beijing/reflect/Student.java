package beijing.reflect;

/**
 * @author zhouhao
 * @date 2023/7/18 23:33
 */
public class Student {
    private String name;
    private int age;

    public void say(String name, int age) {
        System.out.println(name + age);
    }

    private void sayHello(String name, int age) {
        System.out.println(name + age + " private");
    }
}

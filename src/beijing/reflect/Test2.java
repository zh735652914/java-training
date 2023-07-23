package beijing.reflect;

import java.lang.reflect.Method;

/**
 * @author zhouhao
 * @date 2023/7/18 23:35
 */
public class Test2 {
    public static void main(String[] args) throws Exception {
        Class<Student> clazz = Student.class;
        /*
        Class class1 = Person.class;
		Class class2 = new Person().getClass();
		Class class3 = Class.forName("com.qf.d_reflect.Person");
         */
        Method method = clazz.getMethod("say", String.class, int.class, String.class);
        // 如果写了有参的构造方法，没有无参的构造方法会报错
        method.invoke(clazz.newInstance(), "小明", 18, "男");
    }
}

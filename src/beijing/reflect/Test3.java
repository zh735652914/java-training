package beijing.reflect;

import java.lang.reflect.Method;

/**
 * @author zhouhao
 * @date 2023/7/18 23:42
 */
public class Test3 {
    public static void main(String[] args) throws Exception {
        Class clazz = Student.class;
        Object obj = clazz.newInstance();
        Method method = clazz.getDeclaredMethod("sayHello", String.class, int.class);
        method.setAccessible(true);
        method.invoke(obj, "小王", 19);
    }
}

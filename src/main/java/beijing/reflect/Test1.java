package beijing.reflect;

import java.lang.reflect.Field;

/**
 * @author zhouhao
 * @date 2023/7/18 23:34
 */
public class Test1 {
    public static void main(String[] args) throws NoSuchFieldException, InstantiationException, IllegalAccessException {
        Class clazz = Student.class;
        Field field = clazz.getDeclaredField("name");
        field.setAccessible(true);
        Student student = (Student) clazz.newInstance();
        field.set(student, "小明");
        System.out.println(field.get(student));
    }
}

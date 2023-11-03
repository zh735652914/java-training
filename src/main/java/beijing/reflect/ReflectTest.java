package beijing.reflect;

import java.lang.reflect.Field;

/**
 * @author zhouhao
 * @date 2023/7/23 23:08
 */
public class ReflectTest {
    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        //实例化对象
        Student student = new Student("小明", "男", 18);
        //正常通过对象的get方法访问private(age)变量
        System.out.println("正常通过对象的get方法访问私有变量：age为" + student.getAge());

        /*
        获取反射类
        方法一：通过实例化对象获取
        Class studentClass = student.getClass();
        方法二：直接用路径获取
        Class studentClass = Class.forName("Reflect.Student");
         */
        //方法三：通过该类直接获取
        Class studentClass = Student.class;

        //获取所有字段为age的变量
        Field field = studentClass.getDeclaredField("age");
        //设置忽略修饰符
        field.setAccessible(true);
        //获取成员变量age的值
        Object age = field.get(student);
        System.out.println("通过反射直接获取私有变量：age为" + age);
        //通过放射修改私有变量
        field.set(student, 22);

        //输出该对象信息
        System.out.println("修改后的对象信息：\n" + student);
    }
}

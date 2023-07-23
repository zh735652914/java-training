package beijing.reflect;

/**
 * @author zhouhao
 * @date 2023/7/18 23:33
 */
public class Student {
    private String name;

    public String sex;

    private int age;

    public Student() {

    }

    public Student(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public void say(String name, int age, String sex) {
        System.out.println(name + age + sex);
    }

    private void sayHello(String name, int age) {
        System.out.println(name + age + " private");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}

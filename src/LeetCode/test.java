package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by ZhouHao on 2019/4/3.
 */


class Stu {
    private int age;
    private String name;

    Stu(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stu)) return false;
        Stu stu = (Stu) o;
        return getAge() == stu.getAge() &&
                Objects.equals(getName(), stu.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAge(), getName());
    }
}

public class test {
    public static void main(String[] args) {
        Stu A = new Stu(22, "abc");
        Stu B = new Stu(22, "abc");

//        Integer A = 129;
//        Integer B = 129;
//        String A = "abc";
//        String B = "abc";
//        List<Integer> A = new ArrayList<>();
//        List<Integer> B = new ArrayList<>();
//        A.add(1);
//        B.add(1);
        System.out.println(A == B);
        System.out.println(A.equals(B));
    }
}
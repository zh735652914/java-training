package beijing;

import java.util.TreeSet;

/**
 * @author zhouhao
 * @date 2022/12/30 12:17
 */
// 自己不会写
public class ExamRoom {
    int N;
    TreeSet<Integer> students;

    public ExamRoom(int n) {
        this.N = n;
        students = new TreeSet<>();
    }

    public int seat() {
        int student = 0;
        if (students.size() > 0) {
            int left = students.first();
            Integer pre = null;
            for (Integer stu : students) {
                if (pre != null) {
                    int d = (stu - pre) / 2;
                    if (d > left) {
                        left = d;
                        student = pre + d;
                    }
                }
                pre = stu;
            }
            if (N - 1 - students.last() > left) {
                student = N - 1;
            }
        }
        students.add(student);
        return student;
    }

    public void leave(int p) {
        students.remove(p);
    }

    public static void main(String[] args) {
        ExamRoom examRoom = new ExamRoom(10);
        System.out.println(examRoom.seat()); // return 0, no one is in the room, then the student sits at seat number 0.
        System.out.println(examRoom.seat()); // return 9, the student sits at the last seat number 9.
        System.out.println(examRoom.seat()); // return 4, the student sits at the last seat number 4.
        System.out.println(examRoom.seat()); // return 2, the student sits at the last seat number 2.
        examRoom.leave(4);
        System.out.println(examRoom.seat()); // return 5, the student sits at the last seat number 5.
    }
}

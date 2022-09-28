package Beijing;

public class baidu_1 {
    public static double solution(int hour, int min) {
        int x_min = 6 * min;
        double x_hour = 30 * hour + 30 * ((double) min / 60);
//        System.out.println(x_hour);
        double diff = Math.abs(x_min - x_hour);
        return diff <= 180 ? diff : 360 - diff;
    }

    public static void main(String[] args) {
        System.out.println(solution(3, 30));
        System.out.println(solution(12, 0));
        System.out.println(solution(3, 50));
    }
}

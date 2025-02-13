import java.util.*;

public class BOJ14501 {

    static int[] pay = new int[16];
    static int[] days = new int[16];
    static int N;
    static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 퇴사날

        for (int i = 1; i <= N; i++) { // 퇴사날까지 루프
            int d = sc.nextInt(); // 상담 기간
            int p = sc.nextInt(); // 상담 페이
            pay[i] = p;
            days[i] = d;
        }

        cal(1, 0);
        System.out.println(result);

    }// main end

    public static void cal(int startDay, int money) {
        if (startDay > N + 1)
            return;
        if (startDay == N + 1) {
            result = Math.max(result, money);
            return;
        }

        cal(startDay + 1, money);

        money += pay[startDay];
        startDay += days[startDay];

        cal(startDay, money);
    }
}// class end

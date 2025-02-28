import java.util.*;

public class BOJ15486 {

    static int[] dp;
    static int[] day;
    static int[] pay;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        dp = new int[N + 2];
        day = new int[N + 1];
        pay = new int[N + 1];

        sc.nextLine();

        for (int i = 1; i <= N; i++) {
            day[i] = sc.nextInt(); // 상담기간
            pay[i] = sc.nextInt(); // 상담페이
        }

        System.out.println(bottom());
    }

    public static int bottom() { // 거꾸로 갈까 아니면 정방향으로 갈까

        for (int i = 1; i <= N; i++) {
            int next = i + day[i] - 1;
            int current = i - 1;

            if (next > N) {
                dp[i] = Math.max(dp[i], dp[i - 1]);
                continue;
            }
            dp[next] = Math.max(dp[next], dp[current] + pay[i]);
            // System.out.println(" , next : " + next + ", dp : " + dp[next]);
        }

        return dp[N];
    }

    // public static Integer memo(int start, int total) { //거꾸로 갈까 아니면 정방향으로 갈까

    // if (start == N) {
    // return dp[start];
    // }

    // if (dp[start] == null) {
    // dp[start] = Math.max(memo(start + day[start]-1, total + pay[start]), dp[]);
    // }

    // return dp[start];
    // }
}// class end

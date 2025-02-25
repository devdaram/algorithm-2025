import java.util.*;

public class BOJ2748_bottomup {

    static Long[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        dp = new Long[N + 1];

        System.out.println(memo(N));
    }

    public static Long memo(int N) {
        dp[0] = Long.valueOf(0);
        dp[1] = Long.valueOf(1);

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[N];

    }

}// class end

import java.util.*;

public class BOJ11726 {

    static Integer[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        dp = new Integer[N + 1];

        dp[0] = 0;
        dp[1] = 1;
        System.out.println(memo(N));

        System.out.println(bottom(N));
    }

    public static Integer bottom(int N) {
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }
        return dp[N];
    }

    // 2N을 채우는 방법을 구해라
    public static Integer memo(int N) {

        if (N == 2)
            return dp[N] = 2;

        if (dp[N] == null) {
            dp[N] = memo(N - 2) + memo(N - 1);
        }

        return dp[N] % 10007;

    }

}// class end

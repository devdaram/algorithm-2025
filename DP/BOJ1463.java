import java.util.*;

public class BOJ1463 {

    static Integer[] dp;
    // static int result = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        dp = new Integer[N + 1];

        dp[0] = 0;
        dp[1] = 0;
        System.out.println(memo(N));
    }

    // public static Integer bottomUp(int N) {
    // dp[0] = 0;
    // dp[1] = 1;

    // for (int i = 2; i <= N; i++) {
    // dp[i] = Math.min()
    // }

    // }

    public static Integer memo(int N) {

        if (dp[N] == null) {
            if (N % 6 == 0) {
                dp[N] = Math.min(memo(N - 1), Math.min(memo(N / 2), memo(N / 3))) + 1;
            } else if (N % 3 == 0) {
                dp[N] = Math.min(memo(N / 3), memo(N - 1)) + 1;
            } else if (N % 2 == 0) {
                dp[N] = Math.min(memo(N / 2), memo(N - 1)) + 1;
            } else {
                dp[N] = memo(N - 1) + 1;
            }
        }

        return dp[N];

    }

}// class end

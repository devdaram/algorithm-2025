import java.util.*;

public class BOJ2748 {

    static Long[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        dp = new Long[N + 1];

        System.out.println(memo(N));
    }

    public static Long memo(int N) {
        if (N <= 1) {
            return dp[N] = new Long(N);
        }
        if (dp[N] == null)
            dp[N] = memo(N - 2) + memo(N - 1);

        return dp[N];

    }

}// class end

import java.util.*;

public class BOJ2579_topdown {

    static int steps;
    static int[] dp;
    static int[] score;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        steps = sc.nextInt(); // 계단 갯수
        dp = new int[steps + 1];
        score = new int[steps + 1];

        // 데이터 셋팅
        for (int i = 1; i <= steps; i++) {
            score[i] = sc.nextInt();
        }

        // dp(steps, dp, score);
        dp[0] = 0;
        dp[1] = score[1];
        if (steps >= 2) {
            dp[2] = score[1] + score[2];
        }

        System.out.println(memo(steps));
    }

    public static int memo(int start) {
        if (start == 0) {
            dp[start] = 0;
            return dp[start];
        }
        if (start == 1) {
            dp[start] = score[start];
            return dp[start];
        }
        if (start == 2) {
            dp[start] = score[1] + score[2];
            return dp[start];
        }

        if (dp[start] > 0)
            return dp[start];
        dp[start] = Math.max(memo(start - 2) + score[start], memo(start - 3) + score[start - 1] + score[start]);

        return dp[start];
    }

}// class end

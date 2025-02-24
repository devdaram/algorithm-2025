import java.util.*;

public class BOJ2579_bottomup {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int steps = sc.nextInt(); // 계단 갯수
        int[] dp = new int[steps + 1];
        int[] score = new int[steps + 1];

        // 데이터 셋팅
        for (int i = 1; i <= steps; i++) {
            score[i] = sc.nextInt();
        }

        dp(steps, dp, score);
        System.out.println(dp[steps]);
    }

    // 연속 세번의 계단은 밟을 수 없고
    // 한번에 두 계단 or 한 계단씩 올라갈 수 있다.
    // 계단을 밟는데 얻을 수 있는 최대 점수를 구하시오.
    public static void dp(int steps, int[] dp, int[] score) {
        dp[0] = 0;
        dp[1] = score[1];
        if (steps >= 2) {
            dp[2] = score[1] + score[2];
        }

        if (steps >= 3) {
            for (int i = 3; i <= steps; i++) {
                dp[i] = Math.max(dp[i - 3] + score[i - 1] + score[i], dp[i - 2] + score[i]);
            }
        }
    }

}// class end

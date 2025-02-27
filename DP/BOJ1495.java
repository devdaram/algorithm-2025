import java.util.*;

public class BOJ1495 {

    static Integer[][] dp;
    // static Integer[] sum;
    static int[] V;
    static int S;
    static int N;
    static int M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();// 곡의 갯수
        S = sc.nextInt(); // 곡의 시작 볼륨
        M = sc.nextInt(); // 곡의 최대 볼륨
        dp = new Integer[N + 2][M + 1]; // [각 곡의 순서][볼륨 크기]를 저장
        // sum = new Integer[N + 1];

        V = new int[N + 1];

        sc.nextLine();

        for (int i = 1; i <= N; i++) {
            V[i] = sc.nextInt();
        }

        System.out.println(memo(1, S) + "");

        // System.out.println(bottomUp(N));
    }

    public static Integer memo(int start, int preVolume) {

        // System.out.println("처음 진입 : " + start + " " + preVolume + " ");
        if (preVolume < 0 || preVolume > M) {
            // System.out.println("범위 오류 : " + start + " " + preVolume);
            return -1;
        }

        if (start == N + 1) {
            // System.out.println("탈출 : " + start + " " + preVolume + " " + preVolume + "");
            return dp[start][preVolume] = preVolume;
        }

        if (dp[start][preVolume] == null) {
            // System.out.println("본 계산식 : " + start + " " + preVolume);
            int result2 = memo(start + 1, preVolume - V[start]); // [2][0]
            int result = memo(start + 1, preVolume + V[start]);

            return dp[start][preVolume] = Math.max(result, result2);

            // System.out.println("N : " + start + ", preVolume: " + preVolume + ", " +
            // dp[start][preVolume]);
        }
        // System.out.println("마지막 : " + start + " " + preVolume);
        return dp[start][preVolume];
    }
}// class end

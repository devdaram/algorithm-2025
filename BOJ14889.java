import java.util.*;

public class BOJ14889 {

    static int N;
    static int min = Integer.MAX_VALUE;
    static int[][] arr;
    static int[] member;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 인원 총 N명
        arr = new int[N + 1][N + 1]; // index 1부터 시작
        member = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        getTeam(1, 0);
        System.out.println(min);

    }// main end

    public static void getTeam(int start, int memCount) {
        if (memCount == N / 2) { // 탈출조건 => N/2 명이 되면 빠져나온다
            int result = getMin(); // 팀이 꾸려졌으므로 start, team 의 각 합을 구해야 함
            min = Math.min(min, result); // 최솟값을 return
            return;
        }

        for (int i = start; i <= N; i++) { // 처음 시작부터 짝궁 N/2 명을 구함
            member[i] = 1; // start팀인것을 체크
            getTeam(i + 1, memCount + 1);
            member[i] = 0; // 체킹이 끝났으므로 해제처리
        }
    }

    public static int getMin() {
        int start = 0;
        int team = 0;
        // arr을 돌면서 이제 S 들의 합을 구해야 함
        for (int i = 1; i <= N; i++) { // 문제에서 주어진것처럼 이중루프를 돌면서 합을 구한다
            for (int j = 1; j <= N; j++) {
                if (member[i] == 1 && member[j] == 1) {
                    start += arr[i][j]; // arr[i][j] + arr[j][i]인 줄 알았지만, start에 += 하면 어차피 이중루프 도니까 [i][j]헤더 [j][i]가 더해짐

                }
                if (member[i] == 0 && member[j] == 0) {
                    team += arr[i][j];
                }
            }
        }

        if (start - team > 0) // team이 더 값이 커서 -로 나올 수 있음
            return start - team;
        else
            return team - start;

    }
}// class end

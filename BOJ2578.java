import java.util.*;

public class BOJ2578 {

    static int[][] binggo = new int[5][5];
    static int binggoCount = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {// 행
            for (int j = 0; j < 5; j++) {// 열
                binggo[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < 25; i++) {
            int callNumber = sc.nextInt();

            // 부른 숫자 빙고판에 체크
            for (int k = 0; k < 5; k++) {
                for (int s = 0; s < 5; s++) {
                    if (callNumber == binggo[k][s]) {
                        binggo[k][s] = 0;
                    }
                }
            }

            if (i >= 4) {
                garo();
                sero();
                daegack();
                daegack2();
            }

            if (binggoCount >= 3) {
                System.out.println(i + 1);
                break;
            }

            binggoCount = 0; // 한 텀 돌았으니까 초기화
        }

    }// main end

    public static void garo() {
        for (int i = 0; i < 5; i++) {// 행
            int count = 0;
            for (int j = 0; j < 5; j++) {
                if (binggo[i][j] == 0) // 가로로 하나씩 체크
                    count++;
            }

            if (count == 5)
                binggoCount++;
        }
    }

    public static void sero() {
        for (int i = 0; i < 5; i++) {// 행
            int count = 0;
            for (int j = 0; j < 5; j++) {
                if (binggo[j][i] == 0) // 세로로 하나씩 체크
                    count++;
            }
            if (count == 5)
                binggoCount++;
        }
    }

    public static void daegack() {
        int count = 0;
        for (int j = 0; j < 5; j++) {
            if (binggo[j][j] == 0) // 대각선 하나씩
                count++;
        }
        if (count == 5)
            binggoCount++;
    }

    public static void daegack2() {
        int count = 0;
        for (int j = 0; j < 5; j++) {
            if (binggo[j][4 - j] == 0) // 대각선 하나씩
                count++;
        }

        if (count == 5)
            binggoCount++;

    }
}// class end

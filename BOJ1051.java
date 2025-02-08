import java.util.*;

public class BOJ1051 {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt(); // 행 = 세로
        int N = sc.nextInt(); // 열 = 가로

        int distance = 0; // 정사각형의 길이
        int[][] square = new int[M][N];

        for (int i = 0; i < M; i++) {
            String line = sc.next();
            for (int j = 0; j < N; j++) {
                square[i][j] = line.charAt(j) - '0'; // char을 숫자로 변경
            }
        }

        int startValue = 0;
        int maxValue = 0;

        /**
         * (i,j) (i, k)
         * (i+distance, j) (i+distance, j+distance)
         * 
         */
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                startValue = square[i][j]; // 처음 시작 값을 저장

                for (int k = j + 1; k < N; k++) { // 같은 라인을 돌면서 같은 숫자가 있는지 확인
                    if (startValue == square[i][k]) {
                        distance = k - j; // 같은 숫자가 존자한다면 길이를 구한다
                        // System.out.println(startValue + " " + k + " " + distance);
                        // 그 길이만큼 y값을 늘렸을때에도 같은 숫자가 있는지 확인
                        if (i + distance < M && j + distance < N) {
                            if (startValue == square[i + distance][j]) {
                                if (startValue == square[i + distance][j + distance]) {
                                    // System.out.println(startValue + " " + k + " " + distance);
                                    maxValue = Math.max(maxValue, distance);
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println((maxValue + 1) * (maxValue + 1));
    }// Main end
}// class end

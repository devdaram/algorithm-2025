import java.util.*;

public class BOJ1018_2 {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();
        int[][] chess = new int[M][N];
        int min = 64;

        for (int i = 0; i < M; i++) {
            String line = sc.next();
            // System.out.println(line);

            for (int j = 0; j < N; j++) {
                if (line.charAt(j) == 'W')
                    chess[i][j] = 0; // white
                else
                    chess[i][j] = 1; // black
            }
        }

        int result = 0;

        // 전체 체스판을 돌면서 검사한다
        for (int i = 0; i < M - 7; i++) {
            for (int j = 0; j < N - 7; j++) {

                int endX = i + 8;
                int endY = j + 8;
                result = 0;
                int startColor = chess[i][j];

                // 8인 길이만큼 돌면서 바꿔야 할 색깔 있는지 확인
                for (int x = i; x < endX; x++) {
                    for (int y = j; y < endY; y++) {
                        if (startColor != chess[x][y]) { 
                            result++;
                        }

                        startColor = startColor == 0 ? 1 : 0;
                    }
                    startColor = startColor == 0 ? 1 : 0;
                }

                result = Math.min(result, 64 - result);
                min = Math.min(min, result);

            }
        }

        System.out.println(min);

    }

}

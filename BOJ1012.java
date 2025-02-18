import java.util.*;

public class BOJ1012 {

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        for (int t = 0; t < testCase; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int K = sc.nextInt();

            int[][] arr = new int[N][M]; // 배추밭
            int[][] visited = new int[N][M]; // 방문체크

            for (int i = 0; i < K; i++) {
                int tempX = sc.nextInt();
                int tempY = sc.nextInt();
                arr[tempX][tempY] = 1;
            }

            Queue<Pair> queue = new LinkedList<Pair>();
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] == 1 && visited[i][j] == 0) {
                        queue.add(new Pair(i, j));
                        // bfs(queue, N, M, arr, visited);
                        dfs(i, j, N, M, arr, visited);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    public static void dfs(int x, int y, int N, int M, int[][] arr, int[][] visited) {
        if (visited[x][y] == 1 || arr[x][y] == 0) {
            // System.out.println(x + " " + y);
            return;
        }

        visited[x][y] = 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                // if (arr[nx][ny] == 1 && visited[nx][ny] == 0) {
                // visited[nx][ny] = 1;
                dfs(nx, ny, N, M, arr, visited);
                /// visited[nx][ny] = 0;
                // }
            }
        }

    }

    public static void bfs(Queue<Pair> queue, int N, int M, int[][] arr, int[][] visited) {
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            int x = p.x;
            int y = p.y;
            visited[x][y] = 1;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (arr[nx][ny] == 1 && visited[nx][ny] == 0) {
                        queue.add(new Pair(nx, ny));
                    }
                }
            }
        }
    }
}// class end

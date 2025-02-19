import java.util.*;

public class BOJ2667 {

    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };
    static int N;
    static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 지도 크기
        sc.nextLine();
        int arr[][] = new int[N][N];
        int visited[][] = new int[N][N];

        for (int i = 0; i < N; i++) {
            String temp = sc.nextLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = temp.charAt(j) - '0';

                // System.out.print(arr[i][j]);
            }

            // System.out.println();
        }

        int total = 0;
        result = 0;

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1 && visited[i][j] == 0) {

                    dfs(i, j, arr, visited, list);
                    list.add(result);
                    total++;
                    result = 0;
                }
            }
        }

        System.out.println(total);
        Collections.sort(list);
        for (int item : list)
            System.out.println(item);

    }

    public static void dfs(int startX, int startY, int[][] arr, int[][] visited, List<Integer> list) {
        if (visited[startX][startY] == 1 || arr[startX][startY] == 0) {

            return;
        }

        visited[startX][startY] = 1;
        result++;
        for (int i = 0; i < 4; i++) {
            int nx = startX + dx[i];
            int ny = startY + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                dfs(nx, ny, arr, visited, list);

            }
        }
    }

}// class end

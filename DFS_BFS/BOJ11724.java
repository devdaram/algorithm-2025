import java.util.*;

public class BOJ11724 {

    static int[][] arr;
    static int[] visited_dfs;
    static int[] visited_bfs;
    static int N;
    static int M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 정점 수
        M = sc.nextInt(); // 정점 수

        sc.nextLine();

        arr = new int[N + 1][N + 1];
        visited_dfs = new int[N + 1];
        visited_bfs = new int[N + 1];

        // 데이터 셋팅
        for (int i = 1; i <= M; i++) {
            int one = sc.nextInt();
            int two = sc.nextInt();
            // System.out.println(one + " " + two);
            arr[one][two] = 1;
            arr[two][one] = 1; // 서로를 연결
        }

        // Stack<Integer> stack = new Stack<Integer>();
        // stack.push(V);
        // dfs_stack(stack);

        // dfs_recursive(V);
        // System.out.println();

        Queue<Integer> queue = new LinkedList<Integer>();
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (visited_bfs[i] == 0) {
                bfs(i, queue);
                cnt++;

            }
        }
        System.out.print(cnt + " ");

    }

    public static void bfs(int start, Queue<Integer> queue) {
        queue.add(start);

        while (!queue.isEmpty()) {
            int next = queue.poll();

            // System.out.print(next + " ");
            if (visited_bfs[next] == 0) {
                visited_bfs[next] = 1; // 방문체크

                for (int i = 1; i <= N; i++) { // next와 연결되어있는 숫자를 찾는다
                    if (arr[next][i] == 1 && visited_bfs[i] == 0) {
                        queue.add(i);
                        // System.out.println("연결: " + i);
                    }
                }
            }
        }
    }
}// class end

import java.util.*;

public class BOJ1260 {

    static int[][] arr;
    static int[] visited_dfs;
    static int[] visited_bfs;
    static int N;
    static int M;
    static int V;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 정점 수
        M = sc.nextInt(); // 정점 수
        V = sc.nextInt(); // 시작 정점 번호
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

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(V);
        dfs_stack(stack);
        System.out.println();
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(V);
        bfs(queue);

    }

    // public static void dfs_recycle(int start) { //재귀
    // if(){
    // return;
    // }
    // for(int i = 1; i<=N; i++){

    // if(visited)
    // dfs_recycle()
    // }
    // }

    public static void dfs_stack(Stack<Integer> stack) {
        while (!stack.isEmpty()) {
            int next = stack.pop();
            if (visited_dfs[next] == 0) {
                visited_dfs[next] = 1; // 방문체크
                System.out.print(next + " ");
                for (int i = N; i > 0; i--) { // next와 연결되어있는 숫자를 찾는다
                    if (arr[next][i] == 1 && visited_dfs[i] == 0) {
                        stack.push(i);
                        // arr[next][i] = ;
                    }
                }
            }
        }

    }

    public static void bfs(Queue<Integer> queue) {
        while (!queue.isEmpty()) {
            int next = queue.poll();
            if (visited_bfs[next] == 0) {
                visited_bfs[next] = 1; // 방문체크
                System.out.print(next + " ");
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

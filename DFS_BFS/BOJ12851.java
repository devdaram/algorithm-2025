import java.util.*;

public class BOJ12851 {

    static int N; // 수빈
    static int K; // 동생
    static int[] visited;
    static int min = Integer.MAX_VALUE;
    static int count = 0;
    static int[] how;

    static class Pair {
        int x;
        int times;

        public Pair(int x, int times) {
            this.x = x;
            this.times = times;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 수빈 위치
        K = sc.nextInt(); // 동생위치
        visited = new int[100001];
        int[] dx = { -1, 1, 2 };
        how = new int[100001];

        bfs(N, dx);
        System.out.println(min);
        System.out.println(how[min++]);

    }

    public static void bfs(int start, int[] dx) {
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.offer(new Pair(start, 0));

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            int x = p.x;
            int time = p.times;

            if (x == K) {
                min = Math.min(time, min);
                if (min == time)
                    how[min]++;
            }

            visited[x] = 1;

            for (int i = 0; i < 3; i++) {
                int nx = getNextX(x, i);
                int nTime = time + 1;
                if (nx >= 0 && nx <= 100000 && visited[nx] == 0) {
                    queue.offer(new Pair(nx, nTime));

                }

            }

        }
    }

    public static int getNextX(int start, int i) {
        if (i == 0)
            return start - 1;
        else if (i == 1)
            return start + 1;
        else
            return start * 2;
    }

}// class end

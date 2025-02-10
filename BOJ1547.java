import java.util.*;

public class BOJ1547 {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt(); // 컵을 바꾸는 횟수
        int[] cup = { 0, 1, 2, 3 }; // cup[1] 에 항상 공이 놓여있다

        for (int i = 0; i < M; i++) { // M회 컵을 바꾼다
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (x == y)
                continue;
            for (int index = 1; index <= 3; index++) {
                if (cup[index] == x)
                    cup[index] = y;
                else if (cup[index] == y)
                    cup[index] = x;
            }
        }

        System.out.println(cup[1]);

    }// Main end
}// class end

import java.util.*;

public class BOJ14888 {

    static int[] num;
    static int N;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int plus;
    static int minus;
    static int multiply;
    static int divide;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 숫자 갯수
        num = new int[N];

        for (int i = 0; i < N; i++) {
            num[i] = sc.nextInt();
        }

        sc.nextLine();

        plus = sc.nextInt();
        minus = sc.nextInt();
        multiply = sc.nextInt();
        divide = sc.nextInt();

        calc(1, 0, 0, 0, 0, num[0]);
        System.out.println(max);
        System.out.println(min);

    }// main end

    public static void calc(int index, int p, int m, int mul, int div, int result) {
        if (index == N) {
            min = Math.min(result, min);
            max = Math.max(result, max);
            return;
        }

        if (p < plus) {
            calc(index + 1, p + 1, m, mul, div, result + num[index]);
        }
        if (m < minus) {
            calc(index + 1, p, m + 1, mul, div, result - num[index]);
        }
        if (mul < multiply) {
            calc(index + 1, p, m, mul + 1, div, result * num[index]);
        }
        if (div < divide) {
            calc(index + 1, p, m, mul, div + 1, result / num[index]);
        }
    }

}// class end

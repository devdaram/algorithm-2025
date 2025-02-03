import java.util.Scanner;

public class BOJ2231 {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 명령의 수
     
        boolean flag = false;
        for (int i = 0; i < N; i++) {
            if (getSum(i) + i == N) {
                System.out.println(i);
                flag = true;
                break;
            }
        }

        if(!flag) 
            System.out.println(0);

    }

    public static Integer getSum(int n) { // 주어진 n을 각 자리 합을 구하는
        int sum = 0;
        int temp = n;

        while (temp > 0) {
            sum += temp % 10; // 일의 자리를 더함
            temp = temp / 10; // 몫을 구함
        }

        return sum;
    }
}

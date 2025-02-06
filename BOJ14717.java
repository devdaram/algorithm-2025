import java.util.*;

public class BOJ14717 {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        boolean isDdang = a == b ? true : false; // true이면 땡
        double totalCaseNum = (18 * 17) / 2; // 153
        int gguet = 0;

        if (isDdang) {
            double winCaseNum = totalCaseNum - (10 - a);
            double temp = (winCaseNum / totalCaseNum);
            System.out.println(String.format("%.3f", temp));

        } else {
            double winCaseNum = 0;
            gguet = (a + b) % 10; // 나머지 계산을 해서 몇끗인지를 구한다
            for (int i = 1; i <= 10; i++) {
                for (int j = i + 1; j <= 10; j++) {
                    if (gguet > ((i + j) % 10)) {
                        if (i == a || j == b || j == a || i == b)
                            winCaseNum += 2;
                        else
                            winCaseNum += 4;
                    }
                }
            }
            double temp = (winCaseNum / totalCaseNum);
            System.out.println(String.format("%.3f", temp));
        }
    }
}

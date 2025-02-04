import java.util.*;

public class BOJ2309 {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);

        // 먼저 총 합을 구한다
        // 총합에서 100을 뺀다
        // 차액이 곧 탈락될 난쟁이 두 명의 키의 합이다
        // 두명의 키의 합이 차액과 같을 경우 그 두명의 제외한다
        int sum = 0;
        int[] nanjang = new int[10];
        for (int i = 1; i <= 9; i++) { //인덱스를 편하게 생각하기 위해 1부터 시작
            int nanjangTall = Integer.parseInt(sc.nextLine()); // 난쟁이 키
            sum += nanjangTall;
            nanjang[i] = nanjangTall;
        }

        Arrays.sort(nanjang);
      
        int temp = sum - 100;
        int one = 0;
        int two = 0;
        for (int i = 1; i < 9; i++) {
            for (int j = 1 + i; j <= 9; j++) {
                if (nanjang[i] + nanjang[j] == temp) {
                    one = i;
                    two = j;

                    break;
                }
            }

            if (one != 0 && two != 0) {
                break;
            }
        }

        for (int i = 1; i <= 9; i++) {
            if (i != one && i != two)
                System.out.println(nanjang[i]);
        }

    }
}

import java.util.*;

public class BOJ10448 {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[46];
        for (int i = 1; i <= 45; i++) {
            arr[i] = (i * (i + 1)) / 2;
        }

        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            int target = Integer.parseInt(sc.nextLine());
            int T = 0;
            while (T < target) {
                T++;
                if (arr[T] > target) {
                    T = T - 1;
                    break;
                }
            }

            int sum = 0;
            boolean flag = false;
            int count = 0;

            for (int k = 1; k <= T; k++) {
                sum += arr[k];
                count += 1;

                for (int w = k; w <= T; w++) {
                    sum += arr[w];
                    count += 1;

                    for (int f = w; f <= T; f++) {
                        sum += arr[f];
                        count += 1;

                        if (sum == target && count == 3) {
                            System.out.println(1);
                            flag = true;
                            break;
                        }

                        sum -= arr[f];
                        count -= 1;
                    }
                    if (flag)
                        break;

                    sum -= arr[w];
                    count -= 1;
                }
                if (flag)
                    break;

                sum -= arr[k];
                count -= 1;
            }
            if (!flag)
                System.out.println(0);
        }

    }
}

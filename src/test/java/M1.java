import java.util.Scanner;

/**
 * Created by BIG-JIAN on 2017/9/9.
 */
public class M1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int k2 = 0;// 2的倍数但不是4的倍数
            int k4 = 0; // 4的倍数
            k:for (int j = 0; j < n; j++) {
                int tmp = sc.nextInt();
                if (tmp % 4 == 0) k4++;
                if (tmp % 2 == 0 && tmp % 4 != 0) k2++;
                //处理
                if (k4 >= n / 2) {
                    System.out.println("Yes");
                    break k;
                }
                int len = n - 2 * k4 - 1;
                if (k2 >= len && k2 != 1) {
                    System.out.println("Yes");
                    break k;
                }
                if (j == n - 1) System.out.println("No");
            }
        }
    }
}
//4
//        3
//        1 10 100
//        4
//        1 2 3 4
//        5
//        1 2 2 3 4
//        6
//        2 2 2 2 2 2

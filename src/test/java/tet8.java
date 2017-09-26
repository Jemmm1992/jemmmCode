import java.util.Scanner;

/**
 * Created by BIG-JIAN on 2017/9/7.
 */
public class tet8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            double sum = n;
            double tmp = n;
            for (int i = 1; i < m; i++) {
                tmp = Math.sqrt(tmp);
                sum += tmp;
            }
            System.out.println(String.format("%.2f", sum));
        }
    }
}

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by BIG-JIAN on 2017/9/21.
 */
public class a3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        int m = sc.nextInt();
        int[] b = new int[m];
        int[] c = new int[n + m];
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
            c[i] = b[i];
        }
        for (int i = m; i < m + n; i++) {
            c[i] = a[i - m];
        }
        Arrays.sort(c);
        if (c.length % 2 == 1) {
            System.out.println(c[c.length / 2]);
        } else {
            int k = c.length / 2;
            double i = (double) (c[k] + c[k - 1]) / 2;
            System.out.println(i);
        }
    }
}

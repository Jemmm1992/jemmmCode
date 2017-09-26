import java.util.*;

public class a4 {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        int m = sc.nextInt();
        int [] b = new int[m];
        for (int i = 0; i < m; i++)
            b[i] = sc.nextInt();
        int [] c = new int[n + m];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < n && j < m) {
            if (a[i] < b[j])
                c[k++] = a[i++];
            else if (a[i] > b[j])
                c[k++] = b[j++];
            else {
                c[k++] = a[i++];
                j++;
            }

        }
        if (i == n) {
            while (j < m)
                c[k++] = b[j++];
        } else {
            while (i < n)
                c[k++] = a[i++];
        }
        int mid = k / 2;
        if (k % 2 == 1)
            System.out.println(c[mid]);
        else {
            double d1 = c[mid];
            double d2 = c[mid - 1];
            System.out.println((d1 + d2) / 2);
        }
    }
}
//4
//1 2 3 4
//4
//1 2 3 4
import java.util.Scanner;


/**
 * Created by BIG-JIAN on 2017/9/21.
 */
public class a2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(missNum(a));
    }

    public static int find(int[] A, int n) {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (A[i] > 0 && A[i] <= n) res[A[i] - 1] = 1;
        }
        for (int i = 0; i < n; i++) {
            if (res[i] == 0) return i + 1;
        }
        return n + 1;
    }

    public static int missNum(int[] a) {
        int l = 0, r = a.length;
        while (l < r) {
            if (a[l] == l + 1) l++;
            else if (a[l] <= l || a[l] > r || a[a[l] - 1] == a[l]) a[l] = a[--r];
            else swap(a, l, a[l] - 1);
        }
        return l + 1;
    }

    public static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}

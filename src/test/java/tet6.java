import java.util.Scanner;

/**
 * Created by BIG-JIAN on 2017/9/2.
 */
public class tet6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int L = sc.nextInt();
        int R = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }
        int aLen = getdp(a);
        int cNum = getC(aLen) / getC(k) / getC(aLen - k);
        int c = R - L + 1;
        if (n >= k && n <= m) {
            System.out.println(cNum * (m - n + 1) * (long) Math.pow(c, m - n) % 10007);
        } else {
            System.out.println(0);
        }
    }

    // 求最长递增子序列的长度
    public static int getdp(int[] a) {
        int[] dp = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int len = 0;
        for (int i = 0; i < a.length; i++) {
            if (dp[i] > len) len = dp[i];
        }
        return len;
    }

    public static int getC(int a) {
        if (a == 0 || a == 1) return 1;
        int sum = 1;
        for (int i = 1; i <= a; i++) {
            sum *= i;
        }
        return sum;
    }

}

//2 3
//2
//1 2
//1 2
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Created by BIG-JIAN on 2017/9/9.
 */
public class m2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int num = s.length() / 2;
        List<String> gen = gen(num);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < gen.size(); i++) {
            if (!s.equals(gen.get(i))) {
                String lcse = lcse(s, gen.get(i));
                if (map.get(lcse.length()) == null) {
                    map.put(lcse.length(), 1);
                } else {
                    map.put(lcse.length(), map.get(lcse.length()) + 1);
                }
            }
        }
        int max = 0;
        for (Integer in : map.keySet()) {
            max = Math.max(in, max);
        }
        System.out.println(map.get(max));
    }

    public static List<String> gen(int n) {
        List<String> result = new ArrayList<>();
        if (n > 0) {
            char[] parentheses = new char[2 * n];
            solve(n, n, parentheses, result);
        }
        return result;
    }

    public static void solve(int left, int right, char[] parentheses, List<String> result) {
        if (left < 0 || right < 0 || right < left) {
        } else if (left == 0 && right == 0) {
            result.add(new String(parentheses));
        } else {
            int idx = parentheses.length - left - right;
            parentheses[idx] = '(';
            solve(left - 1, right, parentheses, result);
            parentheses[idx] = ')';
            solve(left, right - 1, parentheses, result);
        }
    }

    public static String lcse(String str1, String str2) {
        if (str1 == null || str2 == null || str1.equals("") || str2.equals("")) {
            return "";
        }
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        int[][] dp = getdp(chs1, chs2);
        int m = chs1.length - 1;
        int n = chs2.length - 1;
        char[] res = new char[dp[m][n]];
        int index = res.length - 1;
        while (index >= 0) {
            if (n > 0 && dp[m][n] == dp[m][n - 1]) {
                n--;
            } else if (m > 0 && dp[m][n] == dp[m - 1][n]) {
                m--;
            } else {
                res[index--] = chs1[m];
                m--;
                n--;
            }
        }
        return String.valueOf(res);
    }

    public static int[][] getdp(char[] str1, char[] str2) {
        int[][] dp = new int[str1.length][str2.length];
        dp[0][0] = str1[0] == str2[0] ? 1 : 0;
        for (int i = 1; i < str1.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], str1[i] == str2[0] ? 1 : 0);
        }
        for (int j = 1; j < str2.length; j++) {
            dp[0][j] = Math.max(dp[0][j - 1], str1[0] == str2[j] ? 1 : 0);
        }
        for (int i = 1; i < str1.length; i++) {
            for (int j = 1; j < str2.length; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (str1[i] == str2[j]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp;
    }
}

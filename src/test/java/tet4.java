import java.util.Scanner;

/**
 * Created by BIG-JIAN on 2017/8/30.
 */
public class tet4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] c = sc.nextLine().toCharArray();
        if (c[0] >= 'a' && c[0] <= 'z') {
            System.out.println(get1(c));
        } else if (c[0] >= '0' && c[0] <= '9') {
            System.out.println(get2(c));
        } else {
            System.out.println("ERROR");
        }
    }

    public static String get1(char[] c) {
        int sum = 0;
        int k = 0;
        for (int i = c.length - 1; i >= 0; i--) {
            if (c[i] >= 'a' && c[i] <= 'z') {
                sum += (c[i] - 'a' + 1) * Math.pow(26, k++);
            } else {
                return "ERROR";
            }
        }
        return sum + "";
    }

    public static String get2(char[] c) {
        for (int i = 0; i < c.length; i++) {
            if (c[i] < '0' || c[i] > '9') {
                return "ERROR";
            }
        }
        int a = Integer.valueOf(String.valueOf(c));
        StringBuffer sb = new StringBuffer();
        while (a != 0) {
            sb.append((char) (a % 26 + 'a' - 1));
            a /= 26;
        }
        return sb.reverse().toString();
    }

}

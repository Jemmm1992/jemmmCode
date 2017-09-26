import java.util.Scanner;

/**
 * Created by BIG-JIAN on 2017/9/21.
 */
public class a1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(removeMethod(s));
    }

    public static String removeMethod(String s) {
        StringBuffer sb = new StringBuffer();
        int len = s.length();
        int i = 0;
        boolean flag = false;
        for (i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (s.indexOf(c) != s.lastIndexOf(c)) flag = false;
            else flag = true;
            if (i == s.indexOf(c)) flag = true;
            if (flag) sb.append(c);
        }
        return sb.toString();
    }
}
//    Hello World

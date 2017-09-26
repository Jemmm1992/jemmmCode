/**
 * Created by BIG-JIAN on 2017/9/8.
 */

import java.util.*;

public class tet10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] c = s.toCharArray();
        int[] a = new int[c.length];
        for (int i = 0; i < a.length; i++) {
            int count = 0;
            for (int j = i; j < a.length; j++) {
                if (c[i] != '(') {
                    break;
                } else {
                    if (c[j] == ')')
                        break;
                    else
                        count++;
                }
            }
            a[i] = count;
        }
        int val = 1;
        for (int i = 0; i < a.length; i++)
            if (a[i] > 0)
                val *= a[i];

        System.out.println(val);
    }
}

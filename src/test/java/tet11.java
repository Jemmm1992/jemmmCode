/**
 * Created by BIG-JIAN on 2017/9/8.
 */
public class tet11 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
        String ss = "()()()";
        String[] sss = "(((())))".split("\\)");
        System.out.println(sss.length);
        for (int i = 0; i < sss.length; i++) {
            System.out.println(sss[i]);
        }
        System.out.println(ss.indexOf(")", 2));
//        System.out.println(replaceByIndex(ss, 3, "\\)"));
//        bfs(s);
//        System.out.println(count);
    }

    static int count = 0;

    public static void dfs(String s) {
        if (s.equals("")) {
            return;
        }
        int k = s.length() / 2;
        s = s.replaceFirst("\\(", "");
        for (int i = 1; i <= k; i++) {

            String tmp = replaceByIndex(s, i, "\\)");
            if (check(tmp)) {
                dfs(tmp);
            }
            if (tmp.equals("")) {
                count++;
            }
        }
    }

    public static String replaceByIndex(String str, int ind, String rep) {
        String result = "";
        int tmp_i = 0;
        String tmp_str = "";
        for (int i = 0; i < ind; i++) {
            tmp_str = str.substring(tmp_i);
            if (i != ind - 1) {
                result = result + tmp_str.substring(0, tmp_str.indexOf(rep) + 1);
                tmp_i = tmp_i + tmp_str.indexOf(rep) + 1;
            } else {
                result = result + tmp_str.replaceFirst(rep, "");
            }
        }
        return result;
    }


    public static boolean check(String s) {
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                l++;
            } else if (c == ')') {
                if (l > 0) {
                    l--;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return l == 0;
    }
}

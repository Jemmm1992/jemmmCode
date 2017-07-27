/**
 * Created by BIG-JIAN on 2017/7/11.
 */
public class test {
    public static void main(String[] args) {
        String s = "330324199212152837.0000";
        String s1 = handleDecimalPoint(s);
        System.out.println(s1);
        System.out.println(setCardCode(s1));
    }

    public static String handleDecimalPoint(String s){
        String replace = s.replace(".0000", "");
        return replace;
    }

    public static String setCardCode(String s) {
        StringBuffer sb = new StringBuffer(s.length());
        for (int i = 0; i < s.length(); i++) {
            if (i > 3 && i < s.length()-4) {
                sb.append("*");
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}

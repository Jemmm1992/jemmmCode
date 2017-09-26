import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by BIG-JIAN on 2017/8/30.
 */
public class tet3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        HashMap<String, String> map = new HashMap<>();
        map.put("One", "Yi");
        map.put("Two", "Er");
        map.put("Three", "San");
        map.put("Four", "Si");
        map.put("Five", "Wu");
        map.put("Six", "Six");
        map.put("Seven", "Qi");
        map.put("Eight", "Ba");
        map.put("Nine", "Jiu");
        map.put("Zero", "Ling");

        while (s.contains("Double")) {
            int aDouble = s.indexOf("Double");
            String tmp = "";
            String sub = s.substring(aDouble + 6, aDouble + 11 > s.length() ? s.length(): aDouble + 11);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (sub.contains(key))
                    tmp = value;
            }
            s = s.replaceFirst("Double", tmp);
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            s = s.replace(key, value);
        }
        System.out.println(s);
    }
}
//DoubleFive
//ZeroZeroDoubleFive
//OneZeroDoubleThreeDoubleNine
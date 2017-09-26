import java.io.Serializable;
import java.util.IdentityHashMap;
import java.util.Map;

/**
 * Created by BIG-JIAN on 2017/9/19.
 */
public class test1 implements Serializable {
    public static void main(String[] args) {
        String str1 = new String("xx");
        String str2 = new String("xx");
        System.out.println(str1 == str2);

        Map<String ,String> map = new IdentityHashMap<String ,String>();
        map.put(str1, "hello");
        map.put(str2, "world");


        for(Map.Entry<String,String> entry : map.entrySet())
        {
            System.out.println(entry.getKey()+"   " + entry.getValue());
        }
        System.out.println();
        System.out.println("     containsKey---> " + map.containsKey("xx"));
        System.out.println("str1 containsKey---> " + map.containsKey(str1));
        System.out.println("str2 containsKey---> " + map.containsKey(str2));
        System.out.println("      value----> " + map.get("xx"));
        System.out.println("str1  value----> " + map.get(str1));
        System.out.println("str2  value----> " + map.get(str2));
    }


}

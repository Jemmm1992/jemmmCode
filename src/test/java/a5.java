/**
 * Created by BIG-JIAN on 2017/9/26.
 */
public class a5 {


    public static void main(String arg[]) {
        Thread a = new Thread() {
            public void run() {
                System.out.print("a");
            }
        };
        Thread a1 = new Thread() {
            public void run() {
                System.out.print("b");
            }
        };
        a.start();
        a1.start();
        System.out.print("c");
    }
}

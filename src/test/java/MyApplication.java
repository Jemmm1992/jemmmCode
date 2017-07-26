/**
 * Created by BIG-JIAN on 2017/7/23.
 */
class Test {
    public static void hello() {
        System.out.println("hello");
    }
}

public class MyApplication  {
    public static void main(String[] args) {//2
        System.out.println("value=" + switchit(4));//3
    }//4

    public static int switchit(int x) {
        int j = 1;
        switch (x) {
            case 1:
                j++;
            case 2:
                j++;
            case 3:
                j++;
            case 4:
                j++;
            case 5:
                j++;
            default:
                j++;
        }
        return j + x;
    }
}

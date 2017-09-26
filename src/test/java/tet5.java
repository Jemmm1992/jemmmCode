import java.util.Scanner;

/**
 * Created by BIG-JIAN on 2017/8/30.
 */
public class tet5 {

    public static void main(String[] args) {
//        System.out.println(s.replace("\n", " ").replace("\t", ""));
        String s1 = "intadd(intx,inty){intsum=0;sum=x+y;returnsum;}";
        String s2 = "int add(int x,int y){int sum = 0; sum = x+y; return sum; }";
        String s3 = "int add(int x,int y){ int sum = 0; sum = x+y; return sum;}";
        String s4 = "int add(int x,int y){int sum = 0; sum = x+y; return sum;}";
        Scanner sc = new Scanner(System.in);
        String s = "";
        while (sc.hasNextLine()) {
            String tmp =sc.nextLine();
            if(tmp.endsWith("}")){
                s += tmp;
                break;
            }else {
                s += tmp;
            }
        }
        s = s.replace("\n", " ").replace("\t", " ").replace("\r", " ");
        int int1be = s.indexOf("int") + 4;
        int int1en = s.indexOf("(");
        String add = s.substring(int1be, int1en);
        int int2be = s.indexOf("int", int1en) + 4;
        int int2en = s.indexOf(",", int2be);
        String x = s.substring(int2be, int2en);

        int int3be = s.indexOf("int", int2en) + 4;
        int int3en = s.indexOf(")", int3be);
        String y = s.substring(int3be, int3en);

        int int4be = s.indexOf("int", int3en) + 4;
        int int4en = s.indexOf("=", int4be) - 1;
        String sum = s.substring(int4be, int4en);

        s = s.replaceAll(add, "add").replaceAll(x, "x").replaceAll(y, "y").replaceAll(sum, "sum").replace(" ","");
        if (s.equals(s1)) System.out.println(1);
        else System.out.println(0);
    }
}

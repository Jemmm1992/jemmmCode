import java.util.Scanner;

/**
 * Created by BIG-JIAN on 2017/8/21.
 * <p>搜狐第二道
 * 给个我后面想的思路。
 * 6*6、5*5、4*4、3*3一旦出现肯定会占用一个箱子。
 * 2*2、1*1作为基本的单位。
 * <p>
 * 6*6 不需要额外处理
 * 5*5 扣除11个1*1
 * 4*4 扣除5个2*2
 * 3*3 分情况
 * 1个3*3 扣除5个2*2和7个1*1
 * 2个3*3 扣除3个2*2和6个1*1
 * 3个3*3 扣除1个2*2和5个1*1
 * <p>
 * 注意这里有个技巧，1*1的个数和2*2的个数可以扣到负数。
 * 如果1*1和2*2都为负数 直接输出
 * 如果2*2为负数 1*1为正数，那么1*1去补偿2*2以后再计算。
 * 如果都为正数，那么先处理完2*2再处理1*1。
 */
public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String end = "0 0 0 0 0 0";
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            if (s.equals(end)) break;
            String[] a = s.split(" ");
            int[] aa = new int[a.length];
            for (int i = 0; i < a.length; i++) {
                aa[i] = Integer.valueOf(a[i]);
            }
            System.out.println(get(aa));
        }
    }

    public static int get(int[] aa) {
        int sum = 0;
        sum += aa[5]; // 6*6
        sum += aa[4]; // 5*5
        aa[0] -= aa[4] * 11;
        sum += aa[3]; // 4*4
        if (aa[1] - aa[3] * 5 > 0) aa[1] -= aa[3] * 5;
        else {
            if (aa[0] > 0) aa[0] -= (5 * aa[3] - aa[1]);
            aa[1] = 0;
        }
        int k = aa[2] / 4;
        int v = aa[2] % 4;
        sum += k;
        if (aa[0] <= 0 && aa[1] <= 0 && v == 0) {
            return sum;
        }
        sum += 1;
        if (aa[0] > 0 || aa[1] > 0) {
            if (v == 1) {
                if (aa[1] >= 5 * aa[2]) {
                    aa[1] -= 5 * aa[2];
                    aa[0] -= 7 * aa[2];
                } else {
                    aa[0] -= (5 * aa[2] - aa[1]) * 4;
                    aa[1] = 0;
                }
            }
            if (v == 2) {
                if (aa[1] >= 3 * aa[2]) {
                    aa[1] -= 3 * aa[2];
                    aa[0] -= 6 * aa[2];
                } else {
                    aa[0] -= (3 * aa[2] - aa[1]) * 4;
                    aa[1] = 0;
                }
            }
            if (v == 3) {
                if (aa[1] >= 1 * aa[2]) {
                    aa[1] -= 1 * aa[2];
                    aa[0] -= 5 * aa[2];
                } else {
                    aa[0] -= (1 * aa[2] - aa[1]) * 4;
                    aa[1] = 0;
                }
            }
        }

        if (aa[1] > 0) {
            k = aa[1] / 9;
            v = aa[1] % 9;
            sum += k;
        } else {
            v = 0;
        }
        if (v > 0 && aa[0] > 0) {
            sum++;
            aa[0] -= 6 * 6 - 4 * v;
            if (aa[0] > 0) {
                sum += aa[0] / 36;
                if (aa[0] % 36 != 0) sum++;
            }
        } else if (v == 0 && aa[0] > 0) {
            sum += aa[0] / 36;
            if (aa[0] % 36 != 0) sum++;
        }
        return sum;
    }
}
//0 0 4 0 0 1
//7 5 1 0 0 0
//0 0 0 0 0 0

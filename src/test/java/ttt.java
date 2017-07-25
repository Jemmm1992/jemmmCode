import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by BIG-JIAN on 2017/7/22.
 */

/**
 * 输入:
 * 输入节点个数 输入节点坐标
 * 输出:
 * 需要的最小燃料单位数
 * 输入范例:
 * 2
 * 1 2 3 4 5
 * 6 7 8 9 10
 * 输出范例:
 * 2222
 */

public class ttt {
/** 请完成下面这个函数，实现题目要求的功能 **/
    /**
     * 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^
     **/
    public static boolean test(int[] index) {
        for (int i = 0; i < index.length; i++) {
            if (index[i] != -1)
                return true;
        }
        return false;
    }
    public static long guessMyPath(List<Long[]> dimList) {
        long map[][] = new long[dimList.size() + 1][dimList.size() + 1];
        for (int i = 0; i < dimList.size(); i++) {
            Long[] d = dimList.get(i);
            long dis = d[0] + d[1] + d[2] + d[3] * 10 + d[4] * 100;
            map[0][i] = dis;
        }
        for (int i = 1; i < dimList.size() + 1; i++) {
            for (int j = 0; j < dimList.size(); j++) {
                Long[] d1 = dimList.get(i - 1);
                Long[] d2 = dimList.get(j);
                long dis = (int) Math.abs(d1[0] - d2[0]) + (int) Math.abs(d1[1] - d2[1]) + (int) Math.abs(d1[2] - d2[2]);
                dis += (int) Math.abs(d1[3] - d2[3]) * 10;
                dis += (int) Math.abs(d1[4] - d2[4]) * 100;
                map[i][j] = dis;
            }
        }
        //find min
        long dis = map[0][0];
        int index[] = new int[dimList.size()];
        int x = 0;
        for (int i = 0; i < dimList.size(); i++) {
            if (dis >= map[0][i]) {
                dis = map[0][i];
                x = i;
            }
        }
        index[x] = -1;
        x++;
        int xx = 0;
        while (test(index)) {
            long min = 0;
            for (int j = 0; j < dimList.size(); j++) {
                if ((min >= map[x][j] && index[j] != -1 && map[x][j] != 0) || (min == 0 && map[x][j] != 0)) {
                    min = map[x][j];
                    xx = j;
                }
            }
            dis += min;
            x = xx;
            index[x] = -1;
            x++;
        }
        dis += map[0][x - 1];
        return dis;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Long res;
        int dimension_size = Integer.parseInt(in.nextLine().trim());
        List<Long[]> dimList = new ArrayList<Long[]>();
        for (int _dimension_i = 0; _dimension_i < dimension_size; _dimension_i++) {
            Long[] dimension_item = new Long[5];
            String dimItemStr = in.nextLine().trim();
            String[] dimItemStrs = dimItemStr.split(" ");
            for (int j = 0; j < 5; j++) {
                dimension_item[j] = Long.parseLong(dimItemStrs[j]);
            }
            dimList.add(dimension_item);
        }
        res = guessMyPath(dimList);
        System.out.println(res);
    }
}

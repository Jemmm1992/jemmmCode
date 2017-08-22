package com.prototype.common;

/**
 * Created by BIG-JIAN on 2017/8/20.
 */
public class Radom {

    public static void main(String[] args) {
        int n = 17;
        int m = 3;
        rand1ToN(n, m);
    }

    /**
     * 给定一个等概率随机产生1~5的随机函数
     */
    public static int rand1To5() {
        return (int) (Math.random() * 5) + 1;
    }

    /**
     * 使用rand1To5实现等概率随机产生1~7
     * 思路：
     * 1.rand1To5() => 1,2,3,4,5
     * 2.rand1To5()-1 = > 0,1,2,3,4
     * 3.(rand1To5()-1)*5 => 0,5,10,15,20
     * 4.(rand1To5()-1)*5+(rand1To5()-1) => 0,1,2...24
     * 5.如果step4产生的结果大于20，则重复step4
     * 6.step5随机产生0~20，在进行%7的操作，就会等概率生成0~6，在+1生成1~7。
     */
    public static int rand1To7() {
        int num = 0;
        do {
            num = (rand1To5() - 1) * 5 + rand1To5() - 1;
        } while (num > 20);
        return num % 7;
    }

    /**
     * 给定一个p概率产生0,1的函数，实现1~6随机函数
     */
    public static int rand01p() {
        // you can change p to what you like, but it must be (0,1)
        double p = 0.83;
        return Math.random() < p ? 0 : 1;
    }

    public static int rand01() {
        int num;
        do {
            num = rand01p();
        } while (num == rand01p());
        return num;
    }

    public static int rand0To3() {
        return rand01() * 2 + rand01();
    }

    public static int rand1To6() {
        int num = 0;
        do {
            num = rand0To3() * 4 + rand0To3();
        } while (num > 11);
        return num % 6 + 1;
    }

    /**
     * 给定一个等概率随机产生1~M的随机函数，实现随机产生1~N
     * 思路：将N转化成M进制。
     * 举例：N=17，M=3 17的三进制为 121
     * 121，从左到右，每次调用rand1ToM生成一个随机数，当小于等于左边第一位，这次随机有效，进入左边第二位随机。否则无效。
     * 这里设置了一个boolean lastEqual = true; 一旦lastEqual=false。说明无论生成什么都小于在0~16的范围内，就不用进行判断了。
     */
    public static int rand1ToM(int m) {
        return (int) (Math.random() * m) + 1;
    }

    public static int rand1ToN(int n, int m) {
        int[] nMSys = getMSysNum(n - 1, m);
        int[] randNum = getRanMSysNumLessN(nMSys, m);
        return getNumFromMSysNum(randNum, m) + 1;
    }

    // 把value转成m进制的数
    public static int[] getMSysNum(int value, int m) {
        int[] res = new int[32];
        int index = res.length - 1;
        while (value != 0) {
            res[index--] = value % m;
            value = value / m;
        }
        return res;
    }

    // 等概率随机产生一个0~nMsys范围上的数，只不过是m进制表达的。
    public static int[] getRanMSysNumLessN(int[] nMSys, int m) {
        int[] res = new int[nMSys.length];
        int start = 0;
        while (nMSys[start] == 0) {
            start++;
        }
        int index = start;
        boolean lastEqual = true;
        while (index != nMSys.length) {
            res[index] = rand1ToM(m) - 1;
            if (lastEqual) {
                if (res[index] > nMSys[index]) {
                    index = start;
                    lastEqual = true;
                    continue;
                } else {
                    lastEqual = res[index] == nMSys[index];
                }
            }
            index++;
        }
        return res;
    }

    // 把m进制的数转成10进制
    public static int getNumFromMSysNum(int[] mSysNum, int m) {
        int res = 0;
        for (int i = 0; i != mSysNum.length; i++) {
            res = res * m + mSysNum[i];
        }
        return res;
    }

    public static void printCountArray(int[] countArr) {
        for (int i = 0; i != countArr.length; i++) {
            System.out.println(i + " appears " + countArr[i] + " times");
        }
    }

}

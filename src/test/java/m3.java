/**
 * Created by BIG-JIAN on 2017/9/9.
 */
public class m3 {
    public static void main(String[] args) {
        System.out.println(LCS_caculate("()()()","(())()"));
    }
    public static String LCS_caculate(String s1, String s2) {
        int size1 = s1.length();
        int size2 = s2.length();
        int chess[][] = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i <= size1; i++) {//根据上面提到的公式计算矩阵
            for (int j = 1; j <= size2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    chess[i][j] = chess[i - 1][j - 1] + 1;
                } else {
                    chess[i][j] = Math.max(chess[i][j - 1], chess[i - 1][j]);
                }
            }
        }
        int i = size1;
        int j = size2;
        StringBuffer sb = new StringBuffer();
        while ((i != 0) && (j != 0)) {//利用上面得到的矩阵计算子序列，从最右下角往左上走
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                sb.append(s1.charAt(i - 1));//相同时即为相同的子串
                i--;
                j--;
            } else {
                if (chess[i][j - 1] > chess[i - 1][j]) {
                    j--;
                } else {
                    i--;
                }
            }
        }
        System.out.println((double) sb.length() / s2.length() + "," + (double) sb.length() / s1.length());
        return sb.reverse().toString();//记得反转
    }
}

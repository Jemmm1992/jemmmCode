import java.util.Scanner;

/**
 * Created by BIG-JIAN on 2017/8/22.
 */
public class Main {
    class Node {
        int x;
        int y;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node[] a = new Node[n];
        for (int i = 0; i < n; i++) {
            a[i].x = sc.nextInt();
            a[i].y = sc.nextInt();
        }

    }
}

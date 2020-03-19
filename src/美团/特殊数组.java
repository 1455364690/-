package 美团;

import java.util.Scanner;

/**
 * @author sunjh
 * @date 2020/3/17 21:45
 */
public class 特殊数组 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n[] = new int[4];
        for (int i = 0; i < n.length; i++) {
            n[i] = scan.nextInt();
        }
        int pow = (int) Math.pow(n[3] - n[2] + 1, n[0]);
        int res = pow / n[1] % 1000000007;
        System.out.println(res);
//        Scanner reader = new Scanner(System.in);
//        int n = reader.nextInt();
//        int k = reader.nextInt();
//        int L = reader.nextInt();
//        int R = reader.nextInt();
    }

    public static long get(int n, int k, int L, int R) {
        return 0;
    }
}

package 美团;

import java.util.Scanner;

/**
 * @author sunjh
 * @date 2020/3/17 20:53
 */
public class 走格子 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = Integer.parseInt(reader.nextLine());
        String line1 = reader.nextLine();
        String line2 = reader.nextLine();
        int[][] data = new int[2][n];
        for (int i = 0; i < n; i++) {
            if (line1.charAt(i) == '.') {
                data[0][i] = 0;
            } else {
                data[0][i] = 1;
            }
            if (line2.charAt(i) == '.') {
                data[1][i] = 0;
            } else {
                data[1][i] = 1;
            }
        }
        System.out.println(goNet(n, data));
    }

    public static int goNet(int n, int[][] data) {
        int[][] dp = new int[2][n];
        dp[0][0] = 1;
        dp[0][1] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                if (data[j][i] == 1) {
                    dp[j][i] = 0;
                } else {
                    dp[j][i] = dp[0][i - 1] + dp[1][i - 1];
                }
            }
        }
        return dp[1][n - 1] == 0 ? -1 : dp[1][n - 1];
    }
}

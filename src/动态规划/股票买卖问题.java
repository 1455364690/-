package 动态规划;

/**
 * @author sunjh
 * @date 2020/3/15 23:02
 */
public class 股票买卖问题 {
    public static void main(String[] args) {
        int[] prices = {
                1, 2, 3, 4, 5
        };
        //System.out.println(solution2(prices));
        System.out.println(solution3(prices));
    }

    public static int solution2(int[] prices) {
        //f[i][j][k]表示第i天，进行了j次交易，当前状态为k时的最大利润
        //k=0表示没有持有股票，k=1表示持有股票
        int min = -1000;
        int[][] withStock = new int[prices.length + 1][2 + 1];
        int[][] noStock = new int[prices.length + 1][2 + 1];
        for (int i = 0; i <= prices.length; i++) {
            noStock[i][0] = 0;
            withStock[i][0] = min;
        }
        for (int i = 1; i <= 2; i++) {
            withStock[0][i] = min;
            noStock[0][i] = min;
        }
        for (int i = 1; i <= prices.length; i++) {
            for (int j = 1; j <= 2; j++) {
                noStock[i][j] = Math.max(withStock[i - 1][j] + prices[i - 1], noStock[i - 1][j]);
                withStock[i][j] = Math.max(noStock[i - 1][j - 1] - prices[i - 1], withStock[i - 1][j]);
            }
        }
        for (int i = 0; i < noStock.length; ++i) {
            for (int j = 0; j < noStock[0].length; j++) {
                System.out.print(noStock[i][j] + " ");
            }
            System.out.println();
        }
        return 0;
    }

    public static int solution3(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int[][] global = new int[n][3];
        int[][] local = new int[n][3];
        for (int i = 1; i < n; i++) {
            int diff = prices[i] - prices[i - 1];
            for (int j = 1; j <= 2; j++) {
                local[i][j] = Math.max(global[i - 1][j - 1] + Math.max(diff, 0), local[i - 1][j - 1] + diff);
                global[i][j] = Math.max(local[i][j], global[i - 1][j]);

            }
        }
        return global[n - 1][2];
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[] local = new int[3];
        int[] global = new int[3];
        for (int i = 0; i < prices.length - 1; i++) {
            int diff = prices[i + 1] - prices[i];
            for (int j = 2; j >= 1; j--) {
                local[j] = Math.max(global[j - 1] + (diff > 0 ? diff : 0), local[j] + diff);
                global[j] = Math.max(local[j], global[j]);
            }
        }
        return global[2];
    }
}

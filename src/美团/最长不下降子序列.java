package 美团;

import java.util.Scanner;

/**
 * @author sunjh
 * @date 2020/3/19 20:08
 */
public class 最长不下降子序列 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String[] inputnm = reader.nextLine().split(" ");
        int n = Integer.parseInt(inputnm[0]);
        int m = Integer.parseInt(inputnm[1]);
        int[] array = new int[n];
        String string = reader.nextLine();
        for (int i = 0; i < string.length(); i++) {
            array[i] = Integer.parseInt("" + string.charAt(i));
        }
        for (int i = 0; i < m; i++) {
            String cmd = reader.nextLine();
            if (cmd.startsWith("q")) {
                System.out.println(maxSub3(array, n));
            } else {
                String[] inputij = cmd.split(" ");
                int start = Integer.parseInt(inputij[1]) - 1;
                int end = Integer.parseInt(inputij[2]) - 1;
                for (int j = start; j <= end; j++) {
                    array[j] = 1 - array[j];
                }
            }
        }
        reader.close();
    }

    public static int maxSub(int[] array, int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int max = 0;
        for (int i = 1; i < n; i++) {
            int tmpMax = 1;
            for (int j = 0; j < i; j++) {
                if (array[i] >= array[j]) {
                    tmpMax = Math.max(tmpMax, dp[j] + 1);
                }
            }
            dp[i] = tmpMax;
        }
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static int maxSub3(int[] array, int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int max = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = i-1; j >= 0; j--) {
                if (array[j] <= array[i]) {
                    dp[i] = dp[j] + 1;
                    break;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }


    public static int maxSub2(int[] array, int n) {
        int[] tails = new int[n];
        int len = 0;
        for (int i = 0; i < n; i++) {
            int index = binarySearch(tails, len, array[i]);
            tails[index] = array[i];
            if (index == len) {
                len++;
            }
        }
        return len;
    }

    private static int binarySearch(int[] array, int len, int key) {
        int start = 0;
        int end = len;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (array[mid] == key) {
                return mid;
            } else if (array[mid] > key) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}

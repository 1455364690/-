package 美团;

import java.util.Scanner;

/**
 * @author sunjh
 * @date 2020/3/19 19:17
 */
public class 最长上升子串 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int[] array = new int[n];
        int[] tmpMaxStrLeft = new int[n];
        int[] tmpMaxStrRight = new int[n];
        tmpMaxStrLeft[0] = 1;
        tmpMaxStrRight[n - 1] = 1;
        int max = 0;
        for (int i = 0; i < n; i++) {
            array[i] = reader.nextInt();
        }
        for (int i = 1; i < n; i++) {
            if (array[i] > array[i - 1]) {
                tmpMaxStrLeft[i] = tmpMaxStrLeft[i - 1] + 1;
            } else {
                tmpMaxStrLeft[i] = 1;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (array[i] < array[i + 1]) {
                tmpMaxStrRight[i] = tmpMaxStrRight[i + 1] + 1;
            } else {
                tmpMaxStrRight[i] = 1;
            }
        }
        for (int i = 1; i < n - 1; i++) {
            if (array[i - 1] < array[i + 1]) {
                if (tmpMaxStrLeft[i - 1] + tmpMaxStrRight[i + 1] > max) {
                    max = tmpMaxStrLeft[i - 1] + tmpMaxStrRight[i + 1];
                }
            }
        }
        System.out.println(max);
        reader.close();
    }
}

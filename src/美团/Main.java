package 美团;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author sunjh
 * @date 2020/3/19 18:35
 */
public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        long[] array1 = new long[n];
        long[] array2 = new long[n];
        for (int i = 0; i < n; i++) {
            array1[i] = reader.nextLong();
        }
        for (int i = 0; i < n; i++) {
            array2[i] = reader.nextLong();
        }
        long[] max1 = new long[3];
        long[] max2 = new long[3];
        for (int i = 0; i < 3; i++) {
            max1[i] = array1[i];
            max2[i] = array2[i];
        }
        Arrays.sort(max1);
        Arrays.sort(max2);
        for (int i = 3; i < n; i++) {
            if (array1[i] > max1[2]) {
                max1[0] = max1[1];
                max1[1] = max1[2];
                max1[2] = array1[i];
            } else if (array1[i] > max1[1]) {
                max1[0] = max1[1];
                max1[1] = array1[i];
            } else if (array1[i] > max1[0]) {
                max1[0] = array1[i];
            }

            if (array2[i] > max2[2]) {
                max2[0] = max2[1];
                max2[1] = max2[2];
                max2[2] = array2[i];
            } else if (array2[i] > max2[1]) {
                max2[0] = max2[1];
                max2[1] = array2[i];
            } else if (array2[i] > max2[0]) {
                max2[0] = array2[i];
            }
        }
        long res1 = max1[0] + max1[1] + max1[2];
        long res2 = max2[0] + max2[1] + max2[2];
        if (res1 > res2) {
            System.out.println(res1);
        } else {
            System.out.println(res2);
        }
        reader.close();
    }
}

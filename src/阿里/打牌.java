package 阿里;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author sunjh
 * @date 2020/3/20 9:18
 */
public class 打牌 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int[] array = new int[10];
        int[] array2 = new int[10];
        for (int i = 0; i < 10; i++) {
            array[i] = reader.nextInt();
            array2[i] = array[i];
        }
        //System.out.println(sFirstGreed(array));
        //System.out.println(lFirstGreed(array2));
        System.out.println(Math.min(sFirstGreed(array), lFirstGreed(array2)));
        reader.close();
    }

    public static int sFirstGreed(int[] data) {
        int time = 10000000;
        for (int start = 2; start < 8; start++) {
            int[] array = Arrays.copyOf(data,data.length);
            int TT = 0;
            for (int i = start; i < 8; i++) {
                while (array[i - 2] >= 1 && array[i - 1] >= 1 && array[i] >= 1 && array[i + 1] >= 1 && array[i + 2] >= 1) {
                    array[i - 2] -= 1;
                    array[i - 1] -= 1;
                    array[i] -= 1;
                    array[i + 1] -= 1;
                    array[i + 2] -= 1;
                    TT++;
                }
            }
            int tmpMin = 10000000;
            for (int start2 = 2; start2 < 9; start2++) {
                int tmpTime = 0;
                int[] tmpArr = Arrays.copyOf(array, array.length);
                for (int i = start; i < 9; i++) {
                    while (tmpArr[i - 1] >= 2 && tmpArr[i] >= 2 && tmpArr[i + 1] >= 2) {
                        tmpArr[i - 1] -= 2;
                        tmpArr[i] -= 2;
                        tmpArr[i + 1] -= 2;
                        tmpTime++;
                    }
                }
                if (tmpTime < tmpMin) {
                    tmpMin = tmpTime;
                }
            }
            TT+=tmpMin;
            for (int i = 0; i < 10; i++) {
                while (array[i] >= 2) {
                    array[i] -= 2;
                    TT++;
                }
            }
            for (int i = 0; i < 10; i++) {
                while (array[i] >= 1) {
                    array[i] -= 1;
                    TT++;
                }
            }
            if (TT < time){
                time = TT;
            }
        }

        return time;
    }

    public static int lFirstGreed(int[] array) {
        int time = 10000000;
        for (int start = 2; start < 9; start++) {
            int tmpTime = 0;
            int[] tmpArr = Arrays.copyOf(array, array.length);
            for (int i = start; i < 9; i++) {
                while (tmpArr[i - 1] >= 2 && tmpArr[i] >= 2 && tmpArr[i + 1] >= 2) {
                    tmpArr[i - 1] -= 2;
                    tmpArr[i] -= 2;
                    tmpArr[i + 1] -= 2;
                    tmpTime++;
                }
            }
            int others = sFirstGreed(tmpArr);
            tmpTime += others;
            if (tmpTime < time) {
                time = tmpTime;
            }
        }

        return time;
    }
}

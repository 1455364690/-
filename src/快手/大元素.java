package 快手;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author sunjh
 * @date 2020/3/22 19:05
 */
public class 大元素 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        List<Integer> res = new LinkedList<>();
        String[] input = reader.nextLine().split(" ");
        int[] array = new int[input.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(input[i]);
        }
        int max = array[0];
        int max2 = 0;
        if (array.length == 1) {
            System.out.print(-1);
        } else if (array.length == 2) {
            if (array[0] > array[1]) {
                System.out.print(1);
            } else {
                System.out.print(-1);
            }
        } else {
            if (array[1] < array[0]) {
                res.add(1);
                max = array[0];
                max2 = array[1];
            } else {
                max = array[1];
                max2 = array[0];
            }
            for (int i = 2; i < array.length; i++) {
                if (array[i] > max) {
                    max2 = max;
                    max = array[i];
                } else if (array[i] == max) {
                    max2 = max;
                } else if (array[i] >= max2 && array[i] < max) {
                    res.add(i);
                    max2 = array[i];
                }
            }
            if (res.isEmpty()){
                System.out.print(-1);
            }
            for (int i = 0; i < res.size(); i++) {
                if (i == 0){
                    System.out.print(res.get(i));
                }else{
                    System.out.print(" "+res.get(i));
                }
            }
            //System.out.println();
        }
        reader.close();
    }
}

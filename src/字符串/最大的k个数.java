package 字符串;

/**
 * @author sunjh
 * @date 2020/3/16 14:38
 */
public class 最大的k个数 {
    public static void main(String[] args) {
        int[] array = {1, 5, 3, 9, 7, 8, 6, 2, 4};
        maxKNum(array, 3);
        for (int a : array) {
            System.out.print(a + " ");
        }
    }

    public static void maxKNum(int[] array, int k) {
        for (int i = k / 2; i >= 0; i--) {
            adjust(array, i, k);
        }
        for (int i = k; i < array.length; i++) {
            if (array[i] > array[0]) {
                int tmp = array[i];
                array[i] = array[0];
                array[0] = tmp;
                adjust(array, 0, k);
            }
        }
        for (int i = k - 1; i >= 0; i--) {
            int tmp = array[0];
            array[0] = array[i];
            array[i] = tmp;
            adjust(array, 0, i);
        }
    }

    public static void adjust(int[] array, int i, int len) {
        for (int j = 2 * i + 1; j < len; j = 2 * j + 1) {
            if (j + 1 < len && array[j] > array[j + 1]) {
                j++;
            }
            if (array[j] < array[i]) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                i = j;
            }
        }
    }
}

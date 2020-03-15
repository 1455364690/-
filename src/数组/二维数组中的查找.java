package 数组;

/**
 * @author sunjh
 * @date 2020/3/15 16:01
 */
public class 二维数组中的查找 {
    public static void main(String[] args) {

    }

    public static boolean find(int target, int[][] array) {
        int i = 0;
        int j = array[0].length - 1;
        boolean find = false;
        while (i < array.length && j >= 0) {
            if (target == array[i][j]) {
                find = true;
                break;
            } else if (target < array[i][j]) {
                j--;
            } else {
                i++;
            }
        }
        return find;
    }
}

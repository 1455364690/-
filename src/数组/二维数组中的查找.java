package 数组;

/**
 * @author sunjh
 * @date 2020/3/15 16:01
 */
/*
在一个二维数组中（每个一维数组的长度相同），
每一行都按照从左到右递增的顺序排序，
每一列都按照从上到下递增的顺序排序。
请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
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

package 快手;

/**
 * @author sunjh
 * @date 2020/3/22 19:01
 */
public class Solution {
    public static void main(String[] args) {
        int[] array = {175, 173, 174, 163, 182, 177};
        int[] res = DistanceToHigher(array);
        for (int i:res){
            System.out.println(i);
        }
    }
    public static int[] DistanceToHigher(int[] height) {
        // write code here
        int[] res = new int[height.length];
        res[0] = 0;
        for (int i = 1; i < res.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] > height[i]) {
                    res[i] = i - j;
                    break;
                }
            }
        }
        return res;
    }
}

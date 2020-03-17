package 美团;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author sunjh
 * @date 2020/3/17 21:14
 */
public class 序列众数 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int k = reader.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = reader.nextInt();
        }
        System.out.println(get(data, n, k));
    }

    public static int get(int[] data, int n, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int tmp = data[i];
            int or = tmp | k;
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
            if (tmp != or) {
                map.put(or, map.getOrDefault(or, 0) + 1);
            }
        }
        int max = 0;
        int res = 0;
        //System.out.println(map);
        for (Integer key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
                res = key;
            }
        }
        return res;
    }
}

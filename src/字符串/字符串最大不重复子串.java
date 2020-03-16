package 字符串;

import java.util.HashMap;

/**
 * @author sunjh
 * @date 2020/3/16 10:42
 */
public class 字符串最大不重复子串 {
    public static void main(String[] args) {
        System.out.println(longSubStr("ab"));
    }

    public static String longSubStr(String s) {
        int i = 0;
        int j = 0;
        String max = "";
        int maxLen = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (i < s.length() && j < s.length()) {
            if (i == j) {
                if (maxLen == 0) {
                    map.put(s.charAt(i), 1);
                    maxLen = 1;
                    max = s.substring(i, j + 1);
                }
                j++;
            }
            else if (!map.containsKey(s.charAt(j))) {
                map.put(s.charAt(j), 1);
                if (j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    max = s.substring(i, j + 1);
                }
                j++;
            } else {
                map.remove(s.charAt(i));
                i++;
                if (i<s.length()){
                    map.put(s.charAt(i), 1);
                }
            }
        }
        System.out.println(maxLen);
        return max;
    }
}

package 字符串;

/**
 * @author sunjh
 * @date 2020/3/14 23:57
 */
public class KMP {
    public static void main(String[] args) {
        kmp("abcabaabaabcacb", "aba");
    }

    public static void kmp(String s, String t) {
        int[] next = new int[t.length()];
        next[0] = -1;
        next[1] = 0;
        for (int i = 2; i < next.length; i++) {
            int k = next[i - 1];
            while (k != -1) {
                if (t.charAt(k) == t.charAt(i - 1)) {
                    next[i] = k + 1;
                    break;
                } else {
                    k = next[k];
                }
                next[i] = 0;
            }
        }
        int i = 0;
        int j = 0;
        while (i < s.length() - t.length() && j < t.length()) {
            if (j == -1 || s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        System.out.println(i + "," + j);
    }
}

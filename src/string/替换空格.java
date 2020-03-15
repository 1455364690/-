package string;

/**
 * @author sunjh
 * @date 2020/3/15 16:08
 */
public class 替换空格 {
    public static void main(String[] args) {

    }

    public static String replaceSpace(StringBuffer str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
}

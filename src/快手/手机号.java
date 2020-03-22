    package 快手;

    import java.util.LinkedList;
    import java.util.List;
    import java.util.Scanner;

    /**
     * @author sunjh
     * @date 2020/3/22 19:27
     */
    public class 手机号 {
        public static void main(String[] args) {
            Scanner reader = new Scanner(System.in);
            String[] input = reader.nextLine().split(",");
            sort(input);
            List<String> res = new LinkedList<>();
            for (String i : input) {
                if (Math.max(maxShunziNum(i),maxBaoziNum(i))>=3){
                    res.add(i);
                }
            }
            if (res.isEmpty()){
                System.out.println("null");
            }else{
                for (int i=0;i<res.size();i++){
                    if (i == 0){
                        System.out.print(res.get(i));
                    }else{
                        System.out.print(","+res.get(i));
                    }
                }
                System.out.println();
            }
            reader.close();
        }

        public static void sort(String[] array) {
            for (int i = 1; i < array.length; i++) {
                for (int j = i; j > 0; j--) {
                    if (isABigerB(array[j], array[j - 1])) {
                        String tmp = array[j];
                        array[j] = array[j - 1];
                        array[j - 1] = tmp;
                    }
                }
            }
        }

        public static boolean isABigerB(String a, String b) {
            int sa = maxShunziNum(a);
            int ba = maxBaoziNum(a);
            int sb = maxShunziNum(b);
            int bb = maxBaoziNum(b);
            if (Math.max(sa, ba) > Math.max(sb, bb)) {
                return true;
            } else if (Math.max(sa, ba) < Math.max(sb, bb)) {
                return false;
            } else if (ba >= sa) {
                if (sb > bb) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        public static int maxShunziNum(String string) {
            int max = 0;
            for (int i = 0; i < string.length() - 1; i++) {
                int j = i;
                while (j + 1 < string.length() && string.charAt(j) == string.charAt(j + 1) + 1) {
                    j++;
                }
                if (j - i + 1 > max) {
                    max = j - i + 1;
                }
                j = i;
                while (j + 1 < string.length() && string.charAt(j) == string.charAt(j + 1) - 1) {
                    j++;
                }
                if (j - i + 1 > max) {
                    max = j - i + 1;
                }
            }
            return max;
        }

        public static int maxBaoziNum(String string) {
            int max = 0;
            for (int i = 0; i < string.length() - 1; i++) {
                int tmpLen = 1;
                while (i + 1 < string.length() && string.charAt(i) == string.charAt(i + 1)) {
                    i++;
                    tmpLen++;
                }
                if (tmpLen > max) {
                    max = tmpLen;
                }
            }
            return max;
        }
    }

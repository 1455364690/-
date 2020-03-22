package 阿里;

import java.util.*;

/**
 * @author sunjh
 * @date 2020/3/20 8:35
 */
class Node {
    public int start;
    public int end;
    public int length;
}

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = Integer.parseInt(reader.nextLine());
        List<Node> data = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String tmp = reader.nextLine();
            Node node = new Node();
            node.start = (int) tmp.charAt(0);
            node.end = (int) tmp.charAt(tmp.length() - 1);
            node.length = tmp.length();
            data.add(node);
        }
        Collections.sort(data, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.start - o2.start;
            }
        });
        int[] dp = new int[n];
        dp[0] = data.get(0).length;
        int max = dp[0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (data.get(i).start >= data.get(j).end) {
                    if (dp[j] + data.get(i).length > max) {
                        max = dp[j] + data.get(i).length;
                    }
                }
            }
            dp[i] = max;
        }
//        for (int i = 0; i < n; i++) {
//            System.out.println(data.get(i).start + "," + data.get(i).end + "," + data.get(i).length);
//        }
        System.out.println(max);
        reader.close();
    }

    public static int findMax(List<Node> list) {
        int[] dp = new int[list.size()];
        dp[0] = 1;
        for (int i = 0; i < list.size(); i++) {

        }
        return 0;
    }

    public static int binarySearch(int[] array, int start, int end, int key) {

        return 0;
    }
}

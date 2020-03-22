package 快手;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author sunjh
 * @date 2020/3/22 20:00
 */
class Node {
    public int startX;
    public int startY;
    public int endX;
    public int endY;
    public long cost;
}

public class 放芯片 {
    public static int[][] data;
    public static boolean[][] isPut;
    public static int n;
    public static int m;
    public static int a;
    public static int b;

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        n = reader.nextInt();
        m = reader.nextInt();
        a = reader.nextInt();
        b = reader.nextInt();
        data = new int[n][m];
        isPut = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                data[i][j] = reader.nextInt();
                isPut[i][j] = false;
            }
        }
        put();

        reader.close();
    }

    public static void put() {
        boolean canPut = true;
        List<Node> res = new LinkedList<>();
        while (canPut) {
            Node min = new Node();
            min.cost = -1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    long tmp = putCost(i, j);
                    if (tmp >= 0) {
                        if (min.cost == -1 || tmp < min.cost) {
                            min.startX = i;
                            min.startY = j;
                            min.cost = tmp;
                        }
                    }
                }
            }
            if (min.cost == -1) {
                canPut = false;
            } else {
                modi(min);
                res.add(min);
            }
        }
        System.out.println(res.size());
        for (Node tmp : res) {
            System.out.println((tmp.startX + 1) + " " + (tmp.startY + 1) + " " + tmp.cost);
        }
    }

    public static long putCost(int x, int y) {
        int minE1 = Integer.MAX_VALUE;
        boolean canPut1 = true;
        long minE1Cost = 0;
//        int minE2 = Integer.MAX_VALUE;
//        boolean canPut2 = true;
//        long minE2Cost = 0;
        if (x + a <= n && y + b <= m) {
            for (int i = x; i < x + a; i++) {
                for (int j = y; j < y + b; j++) {
                    if (isPut[i][j]) {
                        canPut1 = false;
                        break;
                    } else if (data[i][j] < minE1) {
                        minE1 = data[i][j];
                    }
                }
                if (!canPut1) {
                    break;
                }
            }
            if (canPut1) {
                for (int i = x; i < x + a; i++) {
                    for (int j = y; j < y + b; j++) {
                        minE1Cost += data[i][j] - minE1;
                    }
                }
            }
        } else {
            canPut1 = false;
        }
//        if (x + b <= n && y + a <= m) {
//            for (int i = x; i < x + b; i++) {
//                for (int j = y; j < y + a; j++) {
//                    if (isPut[i][j]) {
//                        canPut2 = false;
//                        break;
//                    } else if (data[i][j] < minE2) {
//                        minE2 = data[i][j];
//                    }
//                }
//                if (!canPut2) {
//                    break;
//                }
//            }
//            if (canPut2) {
//                for (int i = x; i < x + b; i++) {
//                    for (int j = y; j < y + a; j++) {
//                        minE2Cost += data[i][j] - minE2;
//                    }
//                }
//            }
//        } else {
//            canPut2 = false;
//        }
        Node node = new Node();
        node.startX = x;
        node.startY = y;
        if (canPut1) {
            return minE1Cost;
        } else {
            return -1;
        }
//        if (canPut1 && canPut2) {
//            if (minE1Cost > minE2Cost) {
//                node.endX = x + b;
//                node.endY = y + a;
//                node.cost = minE2Cost;
//            } else {
//                node.endX = x + a;
//                node.endY = y + b;
//                node.cost = minE1Cost;
//            }
//        } else if (canPut1) {
//            node.endX = x + a;
//            node.endY = y + b;
//            node.cost = minE1Cost;
//        } else if (canPut2) {
//            node.endX = x + b;
//            node.endY = y + a;
//            node.cost = minE2Cost;
//        } else {
//            node.cost = -1;
//        }
    }

    public static void modi(Node node) {
        for (int i = node.startX; i < node.startX + a; i++) {
            for (int j = node.startY; j < node.startY + b; j++) {
                isPut[i][j] = true;
            }
        }
    }
}

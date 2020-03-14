package graph;

/**
 * @author sunjh
 * @date 2020/3/14 23:57
 */
public class Floyed {
    static int max = Integer.MAX_VALUE;

    public static void main(String[] args) {
        String[] nodes = {"A", "B", "C", "D", "E", "F", "G"};
        int[][] matrix = {
                {0, 12, max, max, max, 16, 14},
                {12, 0, 10, max, max, 7, max},
                {max, 10, 0, 3, 5, 6, max},
                {max, max, 3, 0, 4, max, max},
                {max, max, 5, 4, 0, 2, 8},
                {16, 7, 6, max, 2, 0, 8},
                {14, max, max, max, 8, 9, 0}
        };
        floyd(nodes, matrix);
    }

    public static void floyd(String[] nodes, int[][] matrix) {
        int[][] A = new int[nodes.length][nodes.length];
        int[][] path = new int[nodes.length][nodes.length];

        for (int i = 0; i < nodes.length; i++) {
            for (int j = 0; j < nodes.length; j++) {
                A[i][j] = matrix[i][j];
                if (i != j && matrix[i][j] < max) {
                    path[i][j] = i;
                } else {
                    path[i][j] = -1;
                }
            }
        }
        for (int k = 0; k < nodes.length; k++) {
            for (int i = 0; i < nodes.length; i++) {
                for (int j = 0; j < nodes.length; j++) {
                    if (A[i][j] > A[i][k] + A[k][j] && A[i][k] + A[k][j] > 0) {
                        A[i][j] = A[i][k] + A[k][j];
                        path[i][j] = path[k][j];
                    }
                }
            }
        }
        for (int i = 0; i < path.length; i++) {
            for (int j = 0; j < path.length; j++) {
                System.out.print(path[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < path.length; i++) {
            for (int j = 0; j < path.length; j++) {
                if (i == j) {
                    continue;
                }
                System.out.print(nodes[i] + "->" + nodes[j] + ":");
                int tmp = j;
                System.out.print(nodes[j]);
                while (tmp != -1 && i != tmp) {
                    System.out.print("<-"+nodes[path[i][tmp]]);
                    tmp = path[i][tmp];
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}

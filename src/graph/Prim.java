package graph;

/**
 * @author sunjh
 * @date 2020/3/14 11:15
 */
public class Prim {
    public static void main(String[] args) {
        int max = Integer.MAX_VALUE;
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
        prim(0, nodes, matrix);

    }

    public static void prim(int start, String[] nodes, int[][] matrix) {
        int nodeNum = nodes.length;
        int[] weights = new int[nodeNum];
        String[] prims = new String[nodeNum];
        int index = 0;
        prims[index++] = nodes[start];
        for (int i = 0; i < nodeNum; i++) {
            weights[i] = matrix[start][i];
        }
        weights[start] = 0;

        for (int i = 0; i < nodeNum; i++) {
            if (i == start) {
                continue;
            }
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            for (int j = 0; j < nodeNum; j++) {
                if (weights[j] < min && weights[j] != 0) {
                    min = weights[j];
                    minIndex = j;
                }
            }
            weights[minIndex] = 0;
            prims[index++] = nodes[minIndex];
            for (int j = 0; j < nodeNum; j++) {
                if (weights[j] != 0 && matrix[minIndex][j] < weights[j]) {
                    weights[j] = matrix[minIndex][j];
                }
            }
        }
        for (int i = 0; i < prims.length; i++) {
            System.out.print(prims[i] + "->");
        }
    }
}

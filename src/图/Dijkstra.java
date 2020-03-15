package 图;

/**
 * @author sunjh
 * @date 2020/3/14 22:22
 */
public class Dijkstra {
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
        djkstra(nodes, matrix);
    }

    public static void djkstra(String[] nodes, int[][] edges) {
        int[] path = new int[nodes.length];
        int[] dist = new int[nodes.length];
        int[] visit = new int[nodes.length];
        //初始化
        for (int i = 0; i < nodes.length; i++) {
            dist[i] = edges[0][i];
            visit[0] = 1;
            if (edges[0][i] < max) {
                path[i] = 0;
            } else {
                path[i] = -1;
            }
        }
        for (int i = 0; i < nodes.length; i++) {
            int min = max;
            int next = -1;
            for (int j = 0; j < nodes.length; j++) {
                if (visit[j] == 0 && dist[j] < min) {
                    min = dist[j];
                    next = j;
                }
            }
            if (next != -1) {
                visit[next] = 1;
                for (int j = 0; j < nodes.length; j++) {
                    if (visit[j] == 0 && (dist[next] + edges[next][j]) > 0 && (dist[next] + edges[next][j]) < dist[j]) {
                        path[j] = next;
                        dist[j] = dist[next] + edges[next][j];
                    }
                }
            }
        }
        for (int i = 0; i < nodes.length; i++) {
            System.out.print(path[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < nodes.length; ++i) {
            System.out.println(nodes[0] + "->" + nodes[i] + ":");
            //System.out.print(nodes[i]);
            int tmp = i;
            while (tmp != 0) {
                System.out.print(nodes[tmp] + "<-");
                tmp = path[tmp];
            }
            System.out.println(nodes[0]);
        }
    }
}

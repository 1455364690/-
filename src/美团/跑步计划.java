package 美团;

import java.util.Scanner;

/**
 * @author sunjh
 * @date 2020/3/19 20:48
 */
public class 跑步计划 {
    static int max = 1000;

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int m = reader.nextInt();
        int s = reader.nextInt();
        int[][] data = new int[n][n];
        for (int i = 0; i < m; i++) {
            int a = reader.nextInt();
            int b = reader.nextInt();
            data[a - 1][b - 1] = reader.nextInt();
        }
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                if (data[i][j] != 0){
                    data[i][j] = max;
                }
            }
        }
        String[] node = new String[n];
        for (int i = 0; i < n; i++) {
            node[i] = "" + i;
        }
        int length = reader.nextInt() - 1;
        djkstra(n, data, s-1,length);
        reader.close();
    }

    public static void djkstra(int n, int[][] edges, int start,int length) {
        int[] path = new int[n];
        int[] dist = new int[n];
        int[] visit = new int[n];
        //初始化
        for (int i = 0; i < n; i++) {
            dist[i] = edges[start][i];
            visit[start] = 1;
            if (edges[start][i] < max) {
                path[i] = 0;
            } else {
                path[i] = -1;
            }
        }
        for (int i = 0; i < n; i++) {
            int min = max;
            int next = -1;
            for (int j = 0; j < n; j++) {
                if (visit[j] == 0 && dist[j] < min) {
                    min = dist[j];
                    next = j;
                }
            }
            if (next != -1) {
                visit[next] = 1;
                for (int j = 0; j < n; j++) {
                    if (visit[j] == 0 && (dist[next] + edges[next][j]) > 0 && (dist[next] + edges[next][j]) < dist[j]) {
                        path[j] = next;
                        dist[j] = dist[next] + edges[next][j];
                    }
                }
            }
        }
        int res = 0;
        for (int i:dist){
            if (i > length && i != max){
                res ++;
            }
            //System.out.print(i+" ");
        }
        System.out.println(res);

    }
}

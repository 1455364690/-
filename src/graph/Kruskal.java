package graph;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sunjh
 * @date 2020/3/14 11:17
 */
class KGraph {

}

class Edge {
    public int start;
    public int end;
    public int weight;

    public Edge() {

    }

    public Edge(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
}

public class Kruskal {
    public static void main(String[] args) {
        int max = Integer.MAX_VALUE;
        String[] nodes = {"A", "B", "C", "D", "E", "F", "G"};
        List<Edge> edges = new LinkedList<>();
        edges.add(new Edge(0, 1, 12));
        edges.add(new Edge(0, 5, 16));
        edges.add(new Edge(0, 6, 14));
        edges.add(new Edge(1, 2, 10));
        edges.add(new Edge(1, 5, 7));
        edges.add(new Edge(2, 3, 3));
        edges.add(new Edge(2, 4, 5));
        edges.add(new Edge(2, 5, 6));
        edges.add(new Edge(3, 4, 4));
        edges.add(new Edge(4, 5, 2));
        edges.add(new Edge(4, 6, 8));
        edges.add(new Edge(5, 6, 9));
        kruskal(nodes, edges);
    }

    public static void kruskal(String[] nodes, List<Edge> edges) {
        Collections.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });
        List<Edge> kruskals = new LinkedList<>();
        int[] targets = new int[nodes.length];
        for (int i = 0; i < targets.length; i++) {
            targets[i] = i;
        }
        for (Edge edge : edges) {
            int start = edge.start;
            int end = edge.end;
            if (targets[start] == targets[end]) {
                continue;
            }
            kruskals.add(edge);
            for (int i = 0; i < targets.length; i++) {
                if (targets[i] == targets[start]) {
                    targets[i] = targets[end];
                }
            }
        }
        for (Edge edge : kruskals) {
            System.out.println("[" + nodes[edge.start] + "," + nodes[edge.end] + "," + edge.weight + "]");
        }
    }
}

package 图;

import java.util.*;

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
        test();
        //kruskal(nodes, edges);
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

    public static void test() {
        //初始化数据
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        //代码段1
        Iterator<Integer> it1 = list.iterator();
        while (it1.hasNext()) {
            int next = (int) it1.next();
            if (next == 5) {
                it1.remove();
            }
        }
        System.out.println(list);

        //代码段2
        for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext(); ) {
            Integer ele = iterator.next();
            if (ele.equals(5)) {
                list.remove(1);
            }
        }
        System.out.println(list);
//        for (int i=0;i<list.size();i++){
//            if (list.get(i) == 8){
//                list.add(1);
//            }
//            System.out.println(list.get(i));
//        }
//        for (int i:list){
//            System.out.println(i);
//            if (i == 5){
//                list.remove(i);
//            }
//        }



    }
}

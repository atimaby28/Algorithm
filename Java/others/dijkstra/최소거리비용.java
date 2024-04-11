package dijkstra;

import java.io.*;
import java.text.ParseException;
import java.util.*;

public class 최소거리비용 {

    public static  int n, m;
    public static ArrayList<ArrayList<Edge>> graph;
    public static int[] distance;

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        distance = new int[n + 1];

        Arrays.fill(distance, Integer.MAX_VALUE);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Edge(b, c));
        }

        dijkstra(1);

        for (int i = 2; i < n + 1; i++) {
            if(distance[i] != Integer.MAX_VALUE) {
                System.out.println(i + " : " + distance[i]);
            } else {
                System.out.println(i + " : impossible");
            }
        }

    }

    private static void dijkstra(int v) {
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new Edge(v, 0));

        distance[v] = 0;

        while (!priorityQueue.isEmpty()) {
            Edge temp = priorityQueue.poll();

            int cur = temp.vex;
            int curCost = temp.cost;

            if(curCost > distance[cur]) {
                continue;
            }

            for (Edge e : graph.get(cur)) {
                if(distance[e.vex] > curCost + e.cost) {
                    distance[e.vex] = curCost + e.cost;
                    priorityQueue.offer(new Edge(e.vex, curCost + e.cost));
                }
            }
        }
    }
}

class Edge implements Comparable<Edge> {
    public int vex;
    public int cost;

    Edge(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}

/*

input :
6 9
1 2 12
1 3 4
2 1 2
2 3 5
2 5 5
3 4 5
4 2 2
4 5 5
6 4 5

output :
2 : 11
3 : 4
4 : 9
5 : 14
6 : impossible

 */

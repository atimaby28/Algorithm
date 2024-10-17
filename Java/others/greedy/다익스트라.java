package greedy;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 다익스트라 {

    public static  int n, m;
    public static ArrayList<ArrayList<EdgeDijk>> graph;
    public static int[] distance;

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

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

            graph.get(a).add(new EdgeDijk(b, c));
        }

        dijkstra(1);

        for (int i = 2; i < n + 1; i++) {
            if(distance[i] != Integer.MAX_VALUE) {
                sb.append(i + " : " + distance[i] + "\n");
            } else {
                sb.append(i + " : impossible" + "\n");
            }
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();

    }

    private static void dijkstra(int v) {
        PriorityQueue<EdgeDijk> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new EdgeDijk(v, 0));

        distance[v] = 0;

        while (!priorityQueue.isEmpty()) {
            EdgeDijk temp = priorityQueue.poll();

            int cur = temp.vex;
            int curCost = temp.cost;

            if(curCost > distance[cur]) {
                continue;
            }

            for (EdgeDijk e : graph.get(cur)) {
                if(distance[e.vex] > curCost + e.cost) {
                    distance[e.vex] = curCost + e.cost;
                    priorityQueue.offer(new EdgeDijk(e.vex, curCost + e.cost));
                }
            }
        }
    }

}

class EdgeDijk implements Comparable<EdgeDijk> {
    public int vex;
    public int cost;

    EdgeDijk(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }

    @Override
    public int compareTo(EdgeDijk o) {
        return this.cost - o.cost;
    }
}

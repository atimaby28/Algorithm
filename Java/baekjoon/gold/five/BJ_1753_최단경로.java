package gold.five;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1753_최단경로 {

    public static int[] distance;
    public static ArrayList<ArrayList<Edge>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int k = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        distance = new int[n + 1];

        Arrays.fill(distance, Integer.MAX_VALUE);

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Edge(v, w));
        }

        Dijkstra(k);

        for (int i = 1; i < distance.length; i++) {
            if(distance[i] != Integer.MAX_VALUE) {
                sb.append(distance[i] + "\n");
            } else {
                sb.append("INF"+ "\n");
            }
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }

    private static void Dijkstra(int k) {
        PriorityQueue<Edge> priorityQueue = new PriorityQueue();
        priorityQueue.offer(new Edge(k, 0));

        distance[k] = 0;

        while (!priorityQueue.isEmpty()) {
            Edge current = priorityQueue.poll();

            int cVertex = current.vertex;
            int cValue = current.value;

            if(cValue > distance[cVertex]) {
                continue;
            }

            for (Edge edge : graph.get(cVertex)) {
                if(distance[edge.vertex] > cValue + edge.value) {
                    distance[edge.vertex] = cValue + edge.value;
                    priorityQueue.offer(new Edge(edge.vertex, cValue + edge.value));
                }
            }

        }
    }
}

class Edge implements Comparable<Edge> {
    public int vertex;
    public int value;

    Edge(int vertex, int value) {
        this.vertex = vertex;
        this.value = value;
    }

    @Override
    public int compareTo(Edge o) {

        return Integer.compare(this.value, o.value);

    }
}
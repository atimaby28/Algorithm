package gold.five;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_5972_택배배송 {

    public static int n, m;
    public static int[] distance;
    public static ArrayList<ArrayList<Barn>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        distance = new int[n + 1];

        Arrays.fill(distance, Integer.MAX_VALUE);

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        int k = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());


            graph.get(v).add(new Barn(u, w));
            graph.get(u).add(new Barn(v, w));
        }

        Dijkstra(1);

        int result = distance[n];

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    private static void Dijkstra(int v) {
        PriorityQueue<Barn> priorityQueue = new PriorityQueue();
        priorityQueue.offer(new Barn(v, 0));

        distance[v] = 0;

        while (!priorityQueue.isEmpty()) {
            Barn cur = priorityQueue.poll();

            int cVertex = cur.vertex;
            int cDist = cur.dist;

            if(cDist > distance[cVertex]) {
                continue;
            }

            for (Barn barn : graph.get(cVertex)) {
                if(distance[barn.vertex] > cDist + barn.dist) {
                    distance[barn.vertex] = cDist + barn.dist;
                    priorityQueue.offer(new Barn(barn.vertex, cDist + barn.dist));
                }
            }
        }
    }


}

class Barn implements Comparable<Barn>{
    int vertex, dist;

    Barn(int vertex, int dist) {
        this.vertex = vertex;
        this.dist = dist;
    }

    @Override
    public int compareTo(Barn o) {
        return Integer.compare(this.dist, o.dist);
    }
}
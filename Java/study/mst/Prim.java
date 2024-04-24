package mst;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Prim {

    public static int ans;
    public static boolean[] visited;
    public static ArrayList<ArrayList<PrimeEdge>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(from).add(new PrimeEdge(to, weight));
            graph.get(to).add(new PrimeEdge(from, weight));
        }

        prime(new PrimeEdge(1, 0));

        bw.write(ans + "\n");

        bw.flush();
        bw.close();
    }

    private static void prime(PrimeEdge edge) {
        PriorityQueue<PrimeEdge> priorityQueue = new PriorityQueue<>();

        priorityQueue.offer(edge);

        while (!priorityQueue.isEmpty()) {
            PrimeEdge pEdge = priorityQueue.poll();

            int vertex = pEdge.vertex;

            if(!visited[vertex]) {
                visited[vertex] = true;

                ans += pEdge.weight;

                for (PrimeEdge pe : graph.get(vertex)) {
                    if(!visited[pe.vertex]) {
                        priorityQueue.offer(new PrimeEdge(pe.vertex, pe.weight));
                    }
                }
            }
        }
    }

}

class PrimeEdge implements Comparable<PrimeEdge> {

    int vertex, weight;

    PrimeEdge(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    @Override
    public int compareTo(PrimeEdge o) {
        return Integer.compare(this.weight, o.weight);
    }
}
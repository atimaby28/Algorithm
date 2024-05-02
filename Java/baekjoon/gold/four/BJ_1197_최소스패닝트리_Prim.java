package gold.four;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1197_최소스패닝트리_Prim {

    public static int V, E;
    public static boolean[] visited;
    public static ArrayList<ArrayList<PrimeEdge>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();

        for (int i = 0; i < V + 1; i++) {
            graph.add(new ArrayList<>());
        }

        visited = new boolean[V + 1];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(from).add(new PrimeEdge(to, weight));
            graph.get(to).add(new PrimeEdge(from, weight));
        }

        int mst = prime(new PrimeEdge(1, 0));

        bw.write(mst + "\n");

        bw.flush();
        bw.close();
    }

    private static int prime(PrimeEdge edge) {
        PriorityQueue<PrimeEdge> priorityQueue = new PriorityQueue<>();

        priorityQueue.offer(edge);

        int weight = 0;
        while (!priorityQueue.isEmpty()) {
            PrimeEdge pEdge = priorityQueue.poll();

            int vertex = pEdge.vertex;

            if(!visited[vertex]) {
                visited[vertex] = true;

                weight += pEdge.weight;

                for (PrimeEdge e : graph.get(vertex)) {
                    priorityQueue.offer(new PrimeEdge(e.vertex, e.weight));
                }
            }
        }

        return weight;
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
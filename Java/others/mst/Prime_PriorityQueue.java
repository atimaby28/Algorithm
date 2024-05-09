package mst;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Prime_PriorityQueue {

    public static int ans;
    public static boolean[] visited;
    public static ArrayList<ArrayList<PrimeEdgePQ>> graph;

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

            graph.get(from).add(new PrimeEdgePQ(to, weight));
            graph.get(to).add(new PrimeEdgePQ(from, weight));
        }

        prime(new PrimeEdgePQ(1, 0));

        bw.write(ans + "\n");

        bw.flush();
        bw.close();
    }

    private static void prime(PrimeEdgePQ edge) {
        PriorityQueue<PrimeEdgePQ> priorityQueue = new PriorityQueue<>();

        priorityQueue.offer(edge);

        while (!priorityQueue.isEmpty()) {
            PrimeEdgePQ pEdge = priorityQueue.poll();

            int vertex = pEdge.vertex;

            if(!visited[vertex]) {
                visited[vertex] = true;

                ans += pEdge.weight;

                for (PrimeEdgePQ pe : graph.get(vertex)) {
                    if(!visited[pe.vertex]) {
                        priorityQueue.offer(new PrimeEdgePQ(pe.vertex, pe.weight));
                    }
                }
            }
        }
    }

}

class PrimeEdgePQ implements Comparable<PrimeEdge> {

    int vertex, weight;

    PrimeEdgePQ(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    @Override
    public int compareTo(PrimeEdge o) {
        return Integer.compare(this.weight, o.weight);
    }
}

/*

input :
9 12
1 2 12
1 9 25
2 3 10
2 8 17
2 9 8
3 4 18
3 7 55
4 5 44
5 6 60
5 7 38
7 8 35
8 9 15

output :
196

 */
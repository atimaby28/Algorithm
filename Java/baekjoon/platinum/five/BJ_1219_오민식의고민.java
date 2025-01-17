package platinum.five;

import java.io.*;
import java.util.*;

public class BJ_1219_오민식의고민 {

    static final long INF = Long.MAX_VALUE;
    static long[] profits, distance;
    static List<Edge> edges = new ArrayList<>();
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] reachableFromNegativeCycle;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // Input processing
        String[] firstLine = br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int start = Integer.parseInt(firstLine[1]);
        int end = Integer.parseInt(firstLine[2]);
        int m = Integer.parseInt(firstLine[3]);

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] edgeInput = br.readLine().split(" ");
            int u = Integer.parseInt(edgeInput[0]);
            int v = Integer.parseInt(edgeInput[1]);
            int w = Integer.parseInt(edgeInput[2]);
            edges.add(new Edge(u, v, w));
            graph.get(u).add(v);
        }

        profits = new long[n];
        String[] profitInput = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            profits[i] = Long.parseLong(profitInput[i]);
        }

        String result = solution(n, start, end);

        // Print output
        bw.write(result);

        bw.flush();
        bw.close();
        br.close();
    }

    private static String solution(int n, int start, int end) {
        StringBuilder sb = new StringBuilder();
        // Initialize distances
        distance = new long[n];
        Arrays.fill(distance, -INF);
        distance[start] = profits[start];

        // Run Bellman-Ford algorithm
        boolean[] inNegativeCycle = runBellmanFord(n);

        // Check if end is reachable from negative cycle
        reachableFromNegativeCycle = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (inNegativeCycle[i]) {
                bfs(i);
            }
        }

        // Output results
        if (reachableFromNegativeCycle[end]) {
            sb.append("Gee").append("\n"); // Infinite profit case
        } else if (distance[end] == -INF) {
            sb.append("gg").append("\n");  // Unreachable case
        } else {
            sb.append(distance[end]).append("\n");  // Maximum profit
        }

        return sb.toString();
    }

    // Bellman-Ford Algorithm
    static boolean[] runBellmanFord(int n) {
        boolean[] inNegativeCycle = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (Edge edge : edges) {
                if (distance[edge.from] != -INF &&
                        distance[edge.from] + profits[edge.to] - edge.weight > distance[edge.to]) {
                    distance[edge.to] = distance[edge.from] + profits[edge.to] - edge.weight;
                    if (i == n - 1) {
                        inNegativeCycle[edge.to] = true; // Mark as part of a negative cycle
                    }
                }
            }
        }
        return inNegativeCycle;
    }

    // BFS to find nodes affected by a negative cycle
    static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        reachableFromNegativeCycle[node] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor : graph.get(current)) {
                if (!reachableFromNegativeCycle[neighbor]) {
                    reachableFromNegativeCycle[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    static class Edge {
        int from, to, weight;

        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
}

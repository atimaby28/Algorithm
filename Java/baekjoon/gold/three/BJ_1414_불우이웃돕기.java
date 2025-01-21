package gold.three;

import java.io.*;
import java.util.*;

public class BJ_1414_불우이웃돕기 {

    static int n, totalCost = 0;
    static boolean[] visited;
    static List<List<Edge>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                char c = s.charAt(j);
                int cost = 0;
                if (c == '0') {
                    cost = 0;
                } else if (Character.isLowerCase(c)) {
                    cost = c - 'a' + 1;
                } else {
                    cost = c - 'A' + 27;
                }
                totalCost += cost;

                if (i != j && cost > 0) {
                    graph.get(i).add(new Edge(j, cost));
                    graph.get(j).add(new Edge(i, cost));
                }
            }
        }

        int mstCost = prim(0);

        if (mstCost == -1) {
            bw.write("-1\n");
        } else {
            bw.write((totalCost - mstCost) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static int prim(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        int mstCost = 0, count = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (visited[cur.to]) continue;

            visited[cur.to] = true;
            mstCost += cur.cost;
            count++;

            for (Edge next : graph.get(cur.to)) {
                if (!visited[next.to]) {
                    pq.add(next);
                }
            }
        }

        return count == n ? mstCost : -1;
    }

    static class Edge implements Comparable<Edge> {
        int to, cost;

        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}

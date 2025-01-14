package gold.four;

import java.io.*;
import java.util.*;

public class BJ_1753_최단경로 {

    public static int[] distance;
    static List<List<Node>> graph;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int start = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();

        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            
            graph.get(from).add(new Node(to, weight));
        }

        distance = new int[v + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        String result = solution(graph, start);

        bw.write(result + "\n");

        bw.flush();

        bw.close();
        br.close();
    }

    private static String solution(List<List<Node>> graph, int start) {
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            int cVertex = node.vertex;
            int cValue = node.value;

            for (Node n : graph.get(cVertex)) {
                if(distance[n.vertex] > cValue + n.value) {
                    distance[n.vertex] = cValue + n.value;
                    pq.offer(new Node(n.vertex, cValue + n.value));
                }
            }
        }

        for (int i = 1; i < distance.length; i++) {
            if(distance[i] != Integer.MAX_VALUE) {
                sb.append(distance[i]).append("\n");
            } else {
                sb.append("INF").append("\n");
            }
        }
        return sb.toString();
    }

    static class Node implements Comparable<Node> {

        int vertex;
        int value;

        public Node(int vertex, int value) {
            this.vertex = vertex;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.value, o.value);
        }
    }
}

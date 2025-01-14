package gold.five;

import java.io.*;
import java.util.*;

public class BJ_1916_최소비용구하기 {

    public static int[] distance;
    static List<List<Node>> graph;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(from).add(new Node(to, weight));
        }

        distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        visit = new boolean[n + 1];
        int result = solution(start, end);

        bw.write(result + "\n");

        bw.flush();

        bw.close();
        br.close();
    }

    private static int solution(int start, int end) {
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Node> pq = new PriorityQueue<>();

        distance[start] = 0;
        pq.offer(new Node(start, 0));

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
        return distance[end];
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

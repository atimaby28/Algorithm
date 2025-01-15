package platinum.four;

import java.io.*;
import java.util.*;

public class BJ_1854_K번째최단경로찾기 {

    static List<List<Node>> graph; // 인접 리스트로 그래프 표현
    static List<PriorityQueue<Integer>> distance; // 각 노드의 K번째 최단 경로를 저장할 우선순위 큐

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 도시 수
        int m = Integer.parseInt(st.nextToken()); // 도로 수
        int k = Integer.parseInt(st.nextToken()); // K번째 최단 경로

        graph = new ArrayList<>();
        distance = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            distance.add(new PriorityQueue<>(k, Collections.reverseOrder())); // 내림차순 우선순위 큐
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Node(to, weight));
        }

        String result = solution(n, k);

        bw.write(result);

        bw.flush();

        bw.close();
        br.close();
    }

    private static String solution(int n, int k) {
        StringBuilder sb = new StringBuilder();

        dijkstra(1, k);

        for (int i = 1; i <= n; i++) {
            if (distance.get(i).size() < k) {
                sb.append("-1").append("\n");
            } else {
                sb.append(distance.get(i).poll()).append("\n");
            }
        }

        return sb.toString();
    }

    private static void dijkstra(int start, int k) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        distance.get(start).offer(0);

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currentNode = current.to;
            int currentWeight = current.weight;

            for (Node neighbor : graph.get(currentNode)) {
                int nextNode = neighbor.to;
                int newWeight = currentWeight + neighbor.weight;

                if (distance.get(nextNode).size() < k) {
                    distance.get(nextNode).offer(newWeight);
                    pq.offer(new Node(nextNode, newWeight));
                } else if (distance.get(nextNode).peek() > newWeight) {
                    distance.get(nextNode).poll();
                    distance.get(nextNode).offer(newWeight);
                    pq.offer(new Node(nextNode, newWeight));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int to, weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
}

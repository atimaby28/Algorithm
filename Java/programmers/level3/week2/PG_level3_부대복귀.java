package level3.week2;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class PG_level3_부대복귀 {
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] roads = new int[n][2];

        for (int i = 0; i < roads.length; i++) {
            st = new StringTokenizer(br.readLine());
            roads[i][0] = Integer.parseInt(st.nextToken());
            roads[i][1] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());

        int[] sources = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < sources.length; i++) {
            sources[i] = Integer.parseInt(st.nextToken());
        }

        int destination = Integer.parseInt(br.readLine());

        int[] result = solution(n, roads, sources, destination);

        bw.write(result + "\n");

        bw.flush();
        br.close();
        bw.close();
    }

    public static int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];

        // 거리 배열 초기화
        distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        // 다익스트라 실행
        dijkstra(roads, destination);

        // 결과 계산
        for (int i = 0; i < sources.length; i++) {
            int source = sources[i];
            answer[i] = (distance[source] == Integer.MAX_VALUE) ? -1 : distance[source];
        }

        return answer;
    }

    public static void dijkstra(int[][] roads, int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int curNode = current.vex;
            int curCost = current.cost;

            if (curCost > distance[curNode]) {
                continue;
            }

            // 모든 간선을 순회
            for (int[] road : roads) {
                int from = road[0];
                int to = road[1];
                int weight = 1; // 문제에서 가중치는 항상 1

                // 현재 노드가 출발점일 때
                if (curNode == from && distance[to] > curCost + weight) {
                    distance[to] = curCost + weight;
                    pq.offer(new Node(to, curCost + weight));
                }

                // 현재 노드가 도착점일 때 (양방향 간선 처리)
                if (curNode == to && distance[from] > curCost + weight) {
                    distance[from] = curCost + weight;
                    pq.offer(new Node(from, curCost + weight));
                }
            }
        }
    }
}


class Node implements Comparable<Node> {
    public int vex;
    public int cost;

    Node(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}


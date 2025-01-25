package level3.week3;

import platinum.five.BJ_1948_임계경로;

import java.io.*;
import java.util.*;

public class PG_level3_등산코스정하기 {

    private static List<List<Node>> graph;
    private static Set<Integer> summitSet;
    private static int[] intensity;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 첫 줄: 도시 개수와 도로 개수
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        // 그래프 초기화
        int[][] paths = new int[k][3];

        // 도로 입력
        for (int i = 0; i < k; i++) {
            String[] info = br.readLine().split(" ");

            paths[i][0] = Integer.parseInt(info[0]);
            paths[i][1] = Integer.parseInt(info[1]);
            paths[i][2] = Integer.parseInt(info[2]);
        }

        int[] gates = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] summits = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] result = solution(n, paths, gates, summits);

        // 결과 출력
        bw.write(result[0] + " " + result[1] + "\n");

        bw.flush();

        bw.close();
        br.close();
    }

    public static int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 그래프 초기화 (양방향)
        for (int[] path : paths) {
            int u = path[0], v = path[1], w = path[2];
            graph.get(u).add(new Node(v, w));
            graph.get(v).add(new Node(u, w));
        }

        // 산봉우리 목록을 빠르게 조회하기 위한 Set
        summitSet = new HashSet<>();
        for (int summit : summits) {
            summitSet.add(summit);
        }

        // 다익스트라 실행
        dijkstra(n, gates);
        
        // 최소 intensity 산봉우리 찾기
        int minSummit = Integer.MAX_VALUE;
        int minIntensity = Integer.MAX_VALUE;

        for (int summit : summits) {
            if (intensity[summit] < minIntensity ||
                    (intensity[summit] == minIntensity && summit < minSummit)) {
                minIntensity = intensity[summit];
                minSummit = summit;
            }
        }

        return new int[]{minSummit, minIntensity};
    }

    private static void dijkstra(int n, int[] gates) {
        // 우선순위 큐 (현재까지의 최대 경로 비용 기준)
        PriorityQueue<Node> pq = new PriorityQueue<>();
        intensity = new int[n + 1];
        Arrays.fill(intensity, Integer.MAX_VALUE);

        // 출입구에서 출발
        for (int gate : gates) {
            pq.add(new Node(gate, 0));
            intensity[gate] = 0;
        }

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currentIdx = current.idx;
            int currentCost = current.cost;

            // 이미 더 좋은 intensity로 방문한 경우 패스
            if (currentCost > intensity[currentIdx]) continue;

            // 산봉우리는 더 이상 진행하지 않음
            if (summitSet.contains(currentIdx)) continue;

            for (Node next : graph.get(currentIdx)) {
                int newIntensity = Math.max(currentCost, next.cost);

                if (newIntensity < intensity[next.idx]) {
                    intensity[next.idx] = newIntensity;
                    pq.add(new Node(next.idx, newIntensity));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int idx, cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.cost, other.cost); // 오름차순 정렬 (최소 intensity 갱신)
        }
    }


}

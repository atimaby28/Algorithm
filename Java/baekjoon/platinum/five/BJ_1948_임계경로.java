package platinum.five;

import java.io.*;
import java.util.*;

public class BJ_1948_임계경로 {

    static int[] dp;
    static int[] inDegree;

    static List<List<Edge>> graph;
    static List<List<Edge>> reverseGraph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 첫 줄: 도시 개수와 도로 개수
        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        // 그래프 초기화
        graph = new ArrayList<>();
        reverseGraph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }

        inDegree = new int[n + 1];
        dp = new int[n + 1];

        // 도로 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Edge(to, weight));
            reverseGraph.get(to).add(new Edge(from, weight));
            inDegree[to]++;
        }

        // 출발 도시와 도착 도시
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        String result = solution(n, start, end);

        // 결과 출력
        bw.write(result + "\n");

        bw.flush();

        bw.close();
        br.close();
    }

    private static String solution(int n, int start, int end) {
        StringBuilder sb = new StringBuilder();
        // 위상 정렬로 최장 시간 계산
        dp = topologicalSort(graph, inDegree, dp, n, start);

        // 역추적하여 임계 경로 계산
        int criticalPathCount = findCriticalPath(reverseGraph, dp, n, end);

        sb.append(dp[end]).append("\n");
        sb.append(criticalPathCount).append("\n");

        return sb.toString();
    }

    // 위상 정렬로 최장 경로 계산
    static int[] topologicalSort(List<List<Edge>> graph, int[] inDegree, int[] dp, int n, int start) {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (Edge edge : graph.get(current)) {
                int next = edge.to;
                int time = edge.weight;
                dp[next] = Math.max(dp[next], dp[current] + time);
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    queue.add(next);
                }
            }
        }
        return dp;
    }

    // 역추적하여 임계 경로 개수 계산
    static int findCriticalPath(List<List<Edge>> reverseGraph, int[] dp, int n, int end) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(end);

        int criticalPathCount = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (Edge edge : reverseGraph.get(current)) {
                int prev = edge.to;
                int time = edge.weight;
                if (dp[current] == dp[prev] + time) {
                    criticalPathCount++;
                    if (!visited[prev]) {
                        visited[prev] = true;
                        queue.add(prev);
                    }
                }
            }
        }

        return criticalPathCount;
    }

    static class Edge {
        int to, weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}

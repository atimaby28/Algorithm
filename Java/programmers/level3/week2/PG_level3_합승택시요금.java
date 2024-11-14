package level3.week2;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Dijkstra 또는 Floyd-Warshall로 풀 수 있다.
public class PG_level3_합승택시요금 {

    static final int MAX = 20000001; // 200 * 100000 + 1
    static ArrayList<ArrayList<Edge>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[][] fares = new int[n * (n - 1) / 2][3];

        for (int i = 0; i < fares.length; i++) {
            st = new StringTokenizer(br.readLine());
            fares[i][0] = Integer.parseInt(st.nextToken());
            fares[i][1] = Integer.parseInt(st.nextToken());
            fares[i][2] = Integer.parseInt(st.nextToken());
        }

        long result = solution(n, s, a, b, fares);

        bw.write(result + "\n");

        bw.flush();
        br.close();
        bw.close();
    }

//    Floyd-Warshall 풀이
//
//    public static int solution(int n, int s, int a, int b, int[][] fares) {
//        int[][] dp = new int[n + 1][n + 1];
//        for (int i = 0; i <= n; i++) {
//            Arrays.fill(dp[i], MAX);
//            dp[i][i] = 0;
//        }
//
//        for(int i = 0; i < fares.length; i++) {
//            int start = fares[i][0];
//            int end = fares[i][1];
//            int cost = fares[i][2];
//
//            dp[start][end] = cost;
//            dp[end][start] = cost;
//        }
//
//        for(int k = 1; k < n+1; k++) {
//            for(int i = 1; i < n+1; i++) {
//                for(int j = 1; j < n+1; j++) {
//                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
//                }
//            }
//        }
//
//
//        int answer = dp[s][a] + dp[s][b];
//        // 경유지점을 끼는경우
//        // s -> t t -> a + t -> b
//        for(int i = 1; i <= n; i++) {
//            answer = Math.min(answer, dp[s][i] + dp[i][a] +dp[i][b]);
//        }
//        return answer;
//    }

//  Dijkstra 풀이
    
    public static int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;

        graph = new ArrayList<>();
        for(int i = 0 ; i <= n ; i ++){
            graph.add(new ArrayList<>());
        }

        for(int[] i : fares){
            graph.get(i[0]).add(new Edge(i[1], i[2]));
            graph.get(i[1]).add(new Edge(i[0], i[2]));
        }

        int[] startA = new int[n + 1];
        int[] startB = new int[n + 1];
        int[] start = new int[n + 1];

        Arrays.fill(startA, MAX);
        Arrays.fill(startB, MAX);
        Arrays.fill(start, MAX);

        startA = dijkstra(a, startA);
        startB = dijkstra(b, startB);
        start = dijkstra(s, start);

        for(int i = 1; i <= n ; i ++)
            answer = Math.min(answer, startA[i] + startB[i] + start[i]);

        return answer;
    }

    static int[] dijkstra (int start, int[] costs) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
        costs[start] = 0;

        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            int nIndex = now.index;
            int nCost = now.cost;

            if(nCost > costs[nIndex]) continue;

            ArrayList<Edge> edges = graph.get(nIndex);
            for (Edge edge : edges) {
                int cost = costs[nIndex] + edge.cost;

                if (cost < costs[edge.index]) {
                    costs[edge.index] = cost;
                    pq.offer(new Edge(edge.index, cost));
                }
            }
        }
        return costs;
    }

}

class Edge implements Comparable<Edge>{
    int index;
    int cost;

    Edge(int index, int cost){
        this.index = index;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge e){
        return Integer.compare(this.cost, e.cost);
    }

}

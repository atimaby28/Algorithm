package gold.four;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_11657_타임머신 {
    public static Bus[] buses;
    public static long[] distance;
    public static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // node
        int m = Integer.parseInt(st.nextToken()); // edge

        buses = new Bus[m];
        distance = new long[n + 1];

        // 최단 거리 테이블 초기화
        for (int i = 1; i < n + 1; i++) {
            distance[i] = INF;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            buses[i] = new Bus(u, v, time);
        }

        String result = solution(n, m);

        bw.write(result);

        bw.flush();

        bw.close();
        br.close();
    }

    public static String solution(int n, int m) {
        StringBuilder sb = new StringBuilder();

        if (bellmanford(1, n, m)) { // 음수 순환 존재하면 -1 출력
            sb.append("-1").append("\n");
        } else {
            // 1번 노드를 제외한 다른 모든 노드로 가기 위한 최단거리 출력
            for (int i = 2; i < n + 1; i++) {
                if (distance[i] == INF) {// 도달할 수 없으면 -1
                    sb.append("-1").append("\n");
                } else { // 최단 거리 출력
                    sb.append(distance[i]).append("\n");
                }
            }
        }

        return sb.toString();
    }

    static boolean bellmanford(int start, int n, int m) {
        distance[start] = 0;

        // n번 반복
        for (int node = 1; node < n + 1; node++) {
            // 매 반복마다 모든 간선을 확인
            for (int edge = 0; edge < m; edge++) {
                int cur = buses[edge].u;
                int next = buses[edge].v;
                int cost = buses[edge].time;

                if (distance[cur] == INF || distance[next] <= distance[cur] + cost) continue;
                // 현재 간선을 거쳐서 다른 노드로 이동하는 거리가 짧은 경우
                if (distance[next] > (distance[cur] + cost)) {
                    distance[next] = distance[cur] + cost;

                    // n번째 라운드에서 값이 갱신된다면 음수 순환 존재
                    if (node == n) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    static class Bus {
        int u, v, time;

        public Bus(int u, int v, int time) {
            this.u = u;
            this.v = v;
            this.time = time;
        }
    }
}
package gold.four;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_11657_타임머신 {
    public static int N, M;
    public static Bus[] e;
    public static long[] dist;
    public static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        e = new Bus[M];
        dist = new long[N + 1];

        // 최단 거리 테이블 초기화
        for (int i = 1; i < N + 1; i++) {
            dist[i] = INF;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            e[i] = new Bus(u, v, time);
        }

        if (bellmanford(1)) { // 음수 순환 존재하면 -1 출력
            System.out.println(-1);
        } else {
            // 1번 노드를 제외한 다른 모든 노드로 가기 위한 최단거리 출력
            for (int i = 2; i < N + 1; i++) {
                if (dist[i] == INF) {// 도달할 수 없으면 -1
                    System.out.println("-1");
                } else { // 최단 거리 출력
                    System.out.println(dist[i]);
                }
            }
        }

    }

    static boolean bellmanford(int start) {
        dist[start] = 0;

        // n번 반복
        for (int i = 1; i < N + 1; i++) {
            // 매 반복마다 모든 간선을 확인
            for (int j = 0; j < M; j++) {
                int cur = e[j].u;
                int next = e[j].v;
                int cost = e[j].time;

                if (dist[cur] == INF) continue;
                // 현재 간선을 거쳐서 다른 노드로 이동하는 거리가 짧은 경우
                if (dist[next] > (dist[cur] + cost)) {
                    dist[next] = dist[cur] + cost;

                    // n번째 라운드에서 값이 갱신된다면 음수 순환 존재
                    if (i == N) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

class Bus {
    int u, v, time;

    public Bus(int u, int v, int time) {
        this.u = u;
        this.v = v;
        this.time = time;
    }
}
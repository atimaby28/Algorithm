package gold.three;

import java.io.*;
import java.util.*;

public class BJ_16202_MST게임 {

    static int N, M;
    static int[][] graph;
    static int[] parents;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(st.nextToken());

        int k = Integer.valueOf(st.nextToken());

        graph = new int[M + 1][2];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            int v1 = Integer.valueOf(st.nextToken());
            int v2 = Integer.valueOf(st.nextToken());

            graph[i][0] = v1;
            graph[i][1] = v2;
        }

        for (int i = 0; i < k; i++) {
            parents = new int[N + 1];

            for (int j = 1; j <= N; j++) {
                parents[j] = j;
            }

            kruskal(i + 1);
        }

        bw.write(sb + "\n");

        bw.flush();
        bw.close();
    }

    private static void kruskal(int min) {

        int answer = 0;
        int edgeCnt = 0;

        for (int i = min; i <= M; i++) {
            int v1 = getParent(graph[i][0]);
            int v2 = getParent(graph[i][1]);

            if (v1 != v2) {
                union(v1, v2);
                answer += i;
                edgeCnt++;
            }

            if (edgeCnt == N - 1) {
                sb.append(answer).append(' ');
                return;
            }
        }
        sb.append(0).append(' ');
    }

    static void union(int v1, int v2) {
        v1 = getParent(v1);
        v2 = getParent(v2);

        if(v1 != v2) {
            int min = Math.min(v1, v2);
            int max = Math.max(v1, v2);

            parents[max] = min;
        }
    }

    static int getParent(int v) {
        if (v == parents[v])
            return v;
        return parents[v] = getParent(parents[v]);
    }

}
// pawer94
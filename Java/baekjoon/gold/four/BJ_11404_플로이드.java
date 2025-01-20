package gold.four;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_11404_플로이드 {

    static long[][] graph;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine()); // node
        int m = Integer.parseInt(br.readLine()); // edge

        graph = new long[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(graph[i], INF);
            graph[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[from][to] = Math.min(graph[from][to], weight);
        }

        String result = solution(n, m);

        bw.write(result);

        bw.flush();

        bw.close();
        br.close();
    }

    private static String solution(int n, int m) {
        StringBuilder sb = new StringBuilder();

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if(graph[i][j] > graph[i][k] + graph[k][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(graph[i][j] == INF) graph[i][j] = 0;
                sb.append(graph[i][j]).append(" ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}

package silver.one;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_11403_경로찾기 {

    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine()); // node

        graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        String result = solution(n);

        bw.write(result);

        bw.flush();

        bw.close();
        br.close();
    }

    private static String solution(int n) {
        StringBuilder sb = new StringBuilder();

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(graph[i][k] == 1 && graph[k][j] == 1) {
                        System.out.println(i + " " + k + " " + k + " " + j);
                        graph[i][j] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(graph[i][j]).append(" ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}

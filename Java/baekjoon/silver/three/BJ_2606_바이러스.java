package silver.three;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_2606_바이러스 {

    static int answer = 0;

    static boolean[] visited;
    static boolean[][] network;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int computer = Integer.parseInt(br.readLine());
        int connect = Integer.parseInt(br.readLine());

        visited = new boolean[computer + 1];
        network = new boolean[computer + 1][computer + 1];

        for (int i = 0; i < connect; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            network[from][to] = true;
            network[to][from] = true;

        }

        dfs(1, computer);

        bw.write(answer + "\n");

        bw.flush();
        bw.close();
    }

    private static void dfs(int idx, int computer) {
        visited[idx] = true;

        for (int i = 1; i <= computer; i++) {
            if(!visited[i] && network[i][idx]) {
                answer++;
                dfs(i, computer);
            }

//            if(i == computer) {
//                return;
//            }
        }

    }

}

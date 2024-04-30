package percompow;

import java.io.*;

public class Powerset {

    public static int N;
    public static boolean[] visited;
    public static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];
        sb = new StringBuilder();

        powerset(1);

        bw.write(sb.toString() + "\n");

        bw.flush();
        bw.close();
    }

    private static void powerset(int depth) {
        if(depth == N + 1) {
            for (int i = 1; i <= N; i++) {
                if(visited[i]) {
                    sb.append(i + " ");
                }
            }
            sb.append("\n");
            return;
        }

        visited[depth] = true;
        powerset(depth + 1);
        visited[depth] = false;
        powerset(depth + 1);

    }
}

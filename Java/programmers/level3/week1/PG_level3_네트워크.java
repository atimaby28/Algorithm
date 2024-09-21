package level3.week1;

import java.io.*;
import java.util.*;

public class PG_level3_네트워크 {

    private static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());

        int[][] computers = new int[k][k];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < k; j++) {
                computers[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = solution(k, computers);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;

        visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                answer += dfs(i, computers);
                //answer += bfs(i, computers);
            }
        }

        return answer;
    }

    public static int dfs(int computer, int[][] computers) {
        visited[computer] = true;

        int connect = 1;

        for(int i = 0; i < computers[computer].length; i++) {
            if(!visited[i] && computers[computer][i] == 1) {
                dfs(i, computers);
            }
        }

        return connect;
    }

    public static int bfs(int computer, int[][] computers) {
        Queue<Integer> queue = new LinkedList<>();

        visited[computer] = true;

        queue.offer(computer);

        int connect = 1;

        while(!queue.isEmpty()) {
            int k = queue.poll();

            for(int i = 0; i < computers[k].length; i++) {
                if(!visited[i] && computers[k][i] == 1) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }

        return connect;

    }

}

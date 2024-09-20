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

        int[][] computers = new int[k][3];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            computers[i][0] = Integer.parseInt(st.nextToken());
            computers[i][1] = Integer.parseInt(st.nextToken());
            computers[i][2] = Integer.parseInt(st.nextToken());
        }

        int result = solution(k, computers);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;

        visited = new boolean[n + 1];

        for(int i = 1; i < n + 1; i++) {
            answer += bfs(i, computers);
        }

        return answer;
    }

    public static int bfs(int n, int[][] computers) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(n);

        visited[n] = true;

        while(!queue.isEmpty()) {
            int k = queue.poll();

            for(int[] computer : computers) {
                if(!visited[n]) {

                }
            }
        }

    }

}

package level2.week2;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level2_피로도 {

    public static int count = 0;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;
        int k = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] board = new int[m][n];

        for (int i = 0; i < board.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = solution(k, board);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];

        dfs(0, k, dungeons);

        return count;
    }

    public static void dfs(int depth, int fatigue, int[][] dungeons){

        for (int i = 0; i < dungeons.length; i++){

            if (visited[i] || dungeons[i][0] > fatigue) {
                continue;
            }

            visited[i] = true;
            dfs(depth + 1, fatigue - dungeons[i][1], dungeons);
            visited[i] = false;
        }

        count = Math.max(count, depth);

    }

}

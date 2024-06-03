package silver.two;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1012_유기농배추 {

    public static int T, M, N, K;

    public static int[][] field;
    public static boolean[][] visited;

    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            field = new int[N][M];
            visited = new boolean[N][M];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                field[y][x] = 1;
            }

            int result = solution(field);

            sb.append(result).append("\n");
        }

        bw.write(sb + "\n");

        bw.flush();
        bw.close();
    }

    private static int solution(int[][] field) {
        int answer = 0;

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                if(!visited[i][j] && field[i][j] == 1) {
                    answer++;
                    bfs(i, j);
                }
            }
        }

        return answer;
    }

    private static void bfs(int y, int x) {
        Queue<Position> queue = new LinkedList<>();

        queue.offer(new Position(y, x));

        visited[y][x] = true;

        while (!queue.isEmpty()) {
            Position pos = queue.poll();

            int cx = pos.x;
            int cy = pos.y;

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx < 0 || nx >= field[0].length || ny < 0 || ny >= field.length) continue;

                if(!visited[ny][nx] && field[ny][nx] == 1) {
                    visited[ny][nx] = true;
                    queue.offer(new Position(ny, nx));
                }
            }
        }
    }

}

class Position {
    int x, y;

    Position(int y, int x) {
        this.x = x;
        this.y = y;
    }
}

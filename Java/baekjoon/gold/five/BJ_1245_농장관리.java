package gold.five;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1245_농장관리 {

    public static boolean[][] visited;

    public static int[] dx = {0, 0, -1, 1, -1, 1, 1, -1};
    public static int[] dy = {-1 ,1, 0, 0, -1, -1, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = solution(map);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(int[][] map) {
        int answer = 0;

        visited = new boolean[map.length][map[0].length];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if(!visited[i][j]) {
                    if(bfs(map, i, j)) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }

    public static boolean bfs(int[][] map, int y, int x) {
        Queue<Position> queue = new LinkedList<>();

        visited[y][x] = true;

        queue.offer(new Position(y, x));

        boolean isSummit = true;

        while (!queue.isEmpty()) {
            Position pos = queue.poll();

            int cx = pos.x;
            int cy = pos.y;

            for (int i = 0; i < 8; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx < 0 || nx >= map[0].length|| ny < 0 || ny >= map.length) continue;

                if (map[cy][cx] < map[ny][nx]) {
                    isSummit = false;
                }

                if(!visited[ny][nx] && map[cy][cx] == map[ny][nx]) {
                    visited[ny][nx] = true;
                    queue.offer(new Position(ny, nx));
                }
            }

        }
        return isSummit;
    }

}

class Position {
    int x, y;

    Position(int y, int x) {
        this.x = x;
        this.y = y;
    }
}

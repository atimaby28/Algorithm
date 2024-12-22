package silver.one;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2178_미로탐색 {

    // 이동 방향 (상, 하, 좌, 우)
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        int result = solution(map);

        bw.write(result + "\n");

        bw.flush();

        bw.close();
        br.close();
    }

    private static int solution(int[][] map) {
        visited = new boolean[map.length][map[0].length];

        return bfs(map);
    }

    // BFS 알고리즘
    private static int bfs(int[][] map) {
        Queue<Position> queue = new ArrayDeque<>();

        queue.offer(new Position(0, 0));

        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Position pos = queue.poll();

            int cx = pos.x;
            int cy = pos.y;

            if(cx == map[0].length - 1 && cy == map.length - 1) {
                return map[cy][cx];
            }

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx < 0 || nx >= map[0].length || ny < 0 || ny >= map.length) continue;

                if(map[ny][nx] == 1 && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    map[ny][nx] = map[cy][cx] + 1;
                    queue.offer(new Position(ny, nx));
                }
            }
        }
        return -1;  // 실행되지 않는 경우 (문제에서는 항상 도달 가능하다고 가정)
    }

    static class Position {
        int x, y;

        Position(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }
}
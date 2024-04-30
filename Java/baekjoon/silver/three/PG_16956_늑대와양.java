package silver.three;

import java.io.*;
import java.util.*;

public class PG_16956_늑대와양 {

    public static int R, C;
    public static char[][] map;
    public static boolean flag = false;
    public static boolean[][] visited;
    public static Queue<Point> queue;

    public static StringBuilder sb;

    public static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
    public static int[] dy = {-1, 1, 0, 0, -1, -1, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        queue = new LinkedList<>();
        visited = new boolean[R][C];
        sb = new StringBuilder();

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);

                if(map[i][j] == 'W') {
                    queue.offer(new Point(i, j));
                }

            }
        }

        bfs();

        if (flag) {
            sb.append(0).append("\n");
        } else {
            sb.append(1).append("\n");
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            Point p = queue.poll();

            int cx = p.x;
            int cy = p.y;

            visited[cy][cx] = true;

            for (int i = 0; i < 8; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx >= 0 && nx < C && ny >= 0 && ny < R) {
                    if(!visited[ny][nx]) {
                        if (map[ny][nx] == '.') {
                            map[ny][nx] = 'D';
                        }

                        if (map[ny][nx] == 'S') {
                            flag = true;
                            return;
                        }
                    }
                }
            }
        }

    }
}

class Point {
    int x, y;

    Point(int y, int x) {
        this.x = x;
        this.y = y;
    }
}

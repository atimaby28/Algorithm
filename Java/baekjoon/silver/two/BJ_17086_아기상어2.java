package silver.two;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_17086_아기상어2 {

    public static int ans = -1;
    public static int n, m;
    public static int[][] map;
    public static boolean[][] visited;

    public static Queue<Point> queue;

    public static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
    public static int[] dy = {-1, 1, 0, 0, -1, -1, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) {
                    queue.offer(new Point(i, j, 0));
                }
            }
        }

        bw.write(bfs() + "\n");

        bw.flush();
        bw.close();

    }

    private static int bfs() {

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            int cx = point.x;
            int cy = point.y;

            for (int i = 0; i < 8; i++) {

                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx >= 0 && nx < map[0].length && ny >= 0 && ny < map.length) {
                    if(map[ny][nx] == 0) {
                        ans = Math.max(ans, point.dist + 1);
                        queue.offer(new Point(ny, nx, point.dist + 1));
                    }
                }
            }
        }
        return ans;
    }
}

class Point {
    int x, y, dist;

    Point(int y, int x, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}
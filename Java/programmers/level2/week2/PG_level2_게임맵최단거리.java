package level2.week2;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class PG_level2_게임맵최단거리 {

    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};

    public static int[][] distance;
    public static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[][] maps = new int[r][c];

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = solution(maps);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(int[][] maps) {
        int answer = 0;

        visited = new boolean[maps.length][maps[0].length];
        distance = new int[maps.length][maps[0].length];

        answer = bfs(maps, 0, 0);

        return answer;
    }

    public static int bfs(int[][] maps, int y, int x) {
        Queue<Position> queue = new LinkedList<>();

        queue.offer(new Position(y, x));

        visited[y][x] = true;

        while (!queue.isEmpty()) {
            Position pos = queue.poll();

            int cx = pos.x;
            int cy = pos.y;

            if(cx == maps[0].length - 1 && cy == maps.length - 1) {
                return distance[cy][cx];
            }

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx < 0 || nx >= maps[0].length || ny < 0 || ny >= maps.length || maps[ny][nx] == 0) continue;

                if(!visited[ny][nx] && maps[ny][nx] == 1) {
                    visited[ny][nx] = true;
                    queue.offer(new Position(ny, nx));

                    if(distance[ny][nx] == 0) {
                        distance[ny][nx] = distance[cy][cx] + 1;
                    }
                }
            }
        }

        return -1;

    }

}

class Position {
    int x, y;

    Position(int y, int x) {
        this.x = x;
        this.y = y;
    }

}

/*
5 5
1 0 1 1 1
1 0 1 0 1
1 0 1 1 1
1 1 1 0 0
0 0 0 0 1
 */
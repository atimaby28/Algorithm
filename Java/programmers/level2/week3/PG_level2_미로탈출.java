package level2.week3;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class PG_level2_미로탈출 {

    public static boolean[][] visited;

    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        String[] maps = new String[n];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            maps[i] = st.nextToken();
        }

        int result = solution(maps);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(String[] maps) {
        int answer = 0;

        char[][] map = new char[maps.length][maps[0].length()];

        int startX = 0, startY = 0;
        int leverX = 0, leverY = 0;

        for (int i = 0; i < map.length; i++) {
            String s = maps[i];
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = s.charAt(j);

                if (map[i][j] == 'S') {
                    startX = j;
                    startY = i;
                } else if (map[i][j] == 'L') {
                    leverX = j;
                    leverY = i;
                }
            }
        }

        int leverDist = bfs(map, startY, startX, 'L');
        int exitDist = bfs(map, leverY, leverX, 'E');

        answer = leverDist + exitDist;

        if (leverDist == -1 || exitDist == -1) {
            answer = -1;
        }

        return answer;

    }

    private static int bfs(char[][] map, int y, int x, char target) {
        Queue<Position> queue = new LinkedList<>();
        visited = new boolean[map.length][map[0].length];

        queue.offer(new Position(y, x, 0));

        visited[y][x] = true;

        while (!queue.isEmpty()) {
            Position pos = queue.poll();

            int cx = pos.x;
            int cy = pos.y;

            if (map[cy][cx] == target) {
                return pos.dist;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || nx > map[0].length - 1 || ny < 0 || ny > map.length - 1) continue;

                if (!visited[ny][nx] && map[ny][nx] != 'X') {
                    visited[ny][nx] = true;
                    queue.offer(new Position(ny, nx, pos.dist + 1));
                }
            }
        }

        return -1;
    }
}

class Position {
    int x, y, dist;

    Position(int y, int x, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}

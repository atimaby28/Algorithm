package level2.week4;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class PG_level2_카카오프렌즈컬러링북 {

    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};

    public static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] picture = new int[m][n];

        for (int i = 0; i < picture.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < picture[i].length; j++) {
                picture[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] result = solution(m, n, picture);


        System.out.println(result[0] + " " + result[1]);


        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[] answer = new int[2];
        visited = new boolean[m][n];

        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[0].length; j++) {
                if (picture[i][j] != 0 && !visited[i][j]) {
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, bfs(picture, i, j));
                }
            }
        }

        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;

        return answer;
    }

    private static int bfs(int[][] picture, int y, int x) {
        Queue<Position> queue = new LinkedList<>();

        visited[y][x] = true;
        queue.offer(new Position(y, x));

        int count = 1;
        while (!queue.isEmpty()) {
            Position pos = queue.poll();

            int cx = pos.x;
            int cy = pos.y;

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx < 0 || nx >= picture[0].length || ny < 0 || ny >= picture.length) continue;

                if(!visited[ny][nx] && picture[ny][nx] == picture[cy][cx]) {
                    queue.offer(new Position(ny, nx));
                    visited[ny][nx] = true;
                    count++;
                }
            }
        }
        return count;
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
6 4
1 1 1 0
1 2 2 0
1 0 0 1
0 0 0 1
0 0 0 3
0 0 0 3
 */

package silver.one;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_3184_양 {

    public static int sheep = 0;
    public static int wolf = 0;

    public static boolean visited[][];

    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        char[][] fence = new char[r][c];

        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
               fence[i][j] = s.charAt(j);
            }
        }

        int[] result = solution(fence);

        bw.write(result[0] + " " + result[1] + "\n");

        bw.flush();
        bw.close();
    }

    public static int[] solution(char[][] fence) {
        int[] answer = new int[2];

        visited = new boolean[fence.length][fence[0].length];

        for (int i = 0; i < fence.length; i++) {
            for (int j = 0; j < fence[0].length; j++) {
                if(!visited[i][j] && fence[i][j] !='#')
                    bfs(fence, i, j);
            }
        }

        answer[0] = sheep;
        answer[1] = wolf;

        return answer;
    }

    public static void bfs(char[][] fence, int y, int x) {
        Queue<Position> queue = new LinkedList<>();

        queue.offer(new Position(y, x));

        visited[y][x] = true;

        int rSheep = 0;
        int rWolf = 0;

        if(fence[y][x] == 'o') {
            rSheep++;
        } else if(fence[y][x] == 'v') {
            rWolf++;
        }
        while (!queue.isEmpty()) {
            Position pos = queue.poll();

            int cx = pos.x;
            int cy = pos.y;

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx < 0 || nx >= fence[0].length || ny < 0 || ny >= fence.length
                        || fence[ny][nx] == '#' || visited[ny][nx]) continue;

                if(fence[ny][nx] == 'o') rSheep++;
                else if(fence[ny][nx] == 'v') rWolf++;

                visited[ny][nx] = true;
                queue.offer(new Position(ny, nx));

            }

        }

        if(rWolf >= rSheep) {
            wolf += rWolf;
        } else {
            sheep += rSheep;
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

package level2.week2;

import java.io.*;
import java.util.HashMap;

public class PG_level2_방문길이 {

    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        int result = solution(s);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(String dirs) {

        int answer = 0;
        boolean[][][] map = new boolean[11][11][4];

        int x = 5;
        int y = 5;

        for (int i = 0; i < dirs.length(); i++) {
            char comm = dirs.charAt(i);
            int dir = 0;
            int reverseDir = 0;

            if (comm == 'U') {
                dir = 0;
                reverseDir = 1;
            } else if (comm == 'D') {
                dir = 1;
                reverseDir = 0;
            } else if (comm == 'L') {
                dir = 2;
                reverseDir = 3;
            } else if (comm == 'R') {
                dir = 3;
                reverseDir = 2;
            }

            if (x + dx[dir] < 0 || x + dx[dir] >= map[0].length || y + dy[dir] < 0 || y + dy[dir] >= map.length)
                continue;

            if (!map[y][x][dir] && !map[y + dy[dir]][x + dx[dir]][reverseDir]) {
                map[y][x][dir] = true;
                map[y + dy[dir]][x + dx[dir]][reverseDir] = true;
                answer++;
            }

            x += dx[dir];
            y += dy[dir];

        }

        return answer;
    }
}

package dfs;

import java.io.*;
import java.util.StringTokenizer;

public class 미로탐색 {

    public static int ans;
    public static int[][] map;
    public static boolean[][] visted;

    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());

        map = new int[n + 1][n + 1];
        visted = new boolean[n + 1][n + 1];

        for (int i = 1; i < map.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < map[i].length; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        visted[1][1] = true;
        dfs(1, 1);

        int result = ans;

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    private static void dfs(int y, int x) {
        if(y == 7 && x == 7) {
            ans++;
        }

        for (int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];

            if(cx >= 1 && cx < map.length && cy >= 1 && cy < map.length) {
                if(map[cy][cx] == 0 && !visted[cy][cx]) {
                    visted[cy][cx] = true;
                    dfs(cy, cx);
                    visted[cy][cx] = false;
                }
            }
        }

    }


}

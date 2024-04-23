package silver.four;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_18422_Emacs {

    public static int ans;
    public static int n, m;
    public static char[][] map;
    public static boolean[][] visited;

    public static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
    public static int[] dy = {-1, 1, 0, 0, -1, -1, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < map.length; i++) {
            String s = br.readLine();
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if(!visited[i][j] && map[i][j] == '*') {
                    ans++;
                    dfs(i, j);
                }
            }
        }

        bw.write(ans + "\n");

        bw.flush();
        bw.close();
    }

    private static void dfs(int y, int x) {
        if(x == m && y == n) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < m && ny >= 0 && ny < n) {
                if(!visited[ny][nx] && map[ny][nx] == '*') {
                    visited[ny][nx] = true;
                    dfs(ny, nx);
                }
            }

        }

    }
}

package dfs;

import java.io.*;
import java.util.StringTokenizer;

public class 섬나라아일랜드 {

    public static int ans;
    public static int[][] map;
    public static boolean[][] visited;

    public static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
    public static int[] dy = {-1, 1, 0, 0, -1, -1, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < map.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if(!visited[i][j] && map[i][j] == 1) {
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
        if(y == map.length && x == map[0].length) {
            return;
        }

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < map[0].length && ny >= 0 && ny < map.length) {
                if(!visited[ny][nx] && map[ny][nx] == 1) {
                    visited[ny][nx] = true;
                    dfs(ny, nx);
                }
            }
        }
    }


}

/*

input :
7
1 1 0 0 0 1 0
0 1 1 0 1 1 0
0 1 0 0 0 0 0
0 0 0 1 0 1 1
1 1 0 1 1 0 0
1 0 0 0 1 0 0
1 0 1 0 1 0 0

output :
5

 */
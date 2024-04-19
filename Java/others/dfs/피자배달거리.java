package dfs;

import java.io.*;
import java.util.StringTokenizer;

public class 피자배달거리 {

    public static int[][] map;
    public static boolean[][] visited;

    public static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
    public static int[] dy = {-1, 1, 0, 0, -1, -1, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < map.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = solution(map, n, m);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static int solution(int[][] map, int n, int m) {
        int answer = 0;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if(map[i][j] == 2) {
                    dfs(i, j, n);
                }
            }
        }

        return answer;
    }

    private static void dfs(int y, int x, int n) {
        if(y == map[0].length && x == map.length) {
            return;
        }

        for (int i = 0; i < 8; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];

            int k = 1;
            while (k < n) {
                int nx = cx * k;
                int ny = cy * k;

                if(nx >= 0 && nx < map[0].length && ny >= 0 && ny < map.length) {
                    if(!visited[ny][nx] && map[ny][nx] == 1) {
                        visited[ny][nx] = true;

                        System.out.println(x + " " + y + " " + nx + " " + ny);
                        dfs(ny, nx, n);

                        visited[ny][nx] = false;
                    }
                }
                k++;
            }
        }
    }

}


/*

input :
4 4
0 1 2 0
1 0 2 1
0 2 1 2
2 0 1 2

output :
6

 */
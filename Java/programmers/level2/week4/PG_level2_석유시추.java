package level2.week4;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level2_석유시추 {

    public static int ans;
    public static int count;
    public static boolean[][] visited;

    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] land = new int[n][m];

        for (int i = 0; i < land.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < land[i].length; j++) {
                land[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = solution(land);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static int solution(int[][] land) {
        int answer = 0;

        for (int i = 0; i < land[0].length; i++) {
            visited = new boolean[land.length][land[0].length];
            count = 0;

            for (int j = 0; j < land.length; j++) {
                if(land[j][i] == 1) {
                    dfs(land, j, i);
                }
            }

            ans = Math.max(ans, count);

        }

        answer = ans;

        return answer;
    }

    private static void dfs(int[][] land, int y, int x) {
        if (y == land.length) {
            ans = Math.max(ans, count);
            return;
        }

        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= land[0].length || ny < 0 || ny >= land.length) continue;

            if(!visited[ny][nx] && land[ny][nx] == 1) {
                visited[ny][nx] = true;
                count++;
                dfs(land, ny, nx);
            }
        }


    }

}
/*
5 8
0 0 0 1 1 1 0 0
0 0 0 0 1 1 0 0
1 1 0 0 0 1 1 0
1 1 1 0 0 0 0 0
1 1 1 0 0 0 1 1
 */
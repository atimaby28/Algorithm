package silver.one;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_14716_현수막 {

    public static int[] dx = {-1, 1, 0, 0, -1, 1, 1, -1};
    public static int[] dy = {0, 0, -1, 1, -1, -1, 1, 1};

    public static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] banner = new int[m][n];

        for (int i = 0; i < banner.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < banner[0].length; j++) {
                banner[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = solution(banner);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(int[][] banner) {
        int answer = 0;

        visited = new boolean[banner.length][banner[0].length];

        for (int i = 0; i < banner.length; i++) {
            for (int j = 0; j < banner[0].length; j++) {
                if(!visited[i][j] && banner[i][j] == 1) {
                    answer++;
                    dfs(banner, i, j);
                }
            }
        }

        return answer;
    }

    public static void dfs(int[][] banner, int y, int x) {

        visited[y][x] = true;

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= banner[0].length || ny < 0 || ny >= banner.length)  continue;

            if(!visited[ny][nx] && banner[ny][nx] == 1) {
                dfs(banner, ny, nx);
            }
        }
    }
}

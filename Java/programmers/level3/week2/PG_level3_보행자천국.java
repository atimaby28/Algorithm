package level3.week2;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level3_보행자천국 {
    static final int MOD = 20170805;

    // 왼쪽, 위쪽
    static int[] dx = {-1, 0};
    static int[] dy = {0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] cityMap = new int[m][n];


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                cityMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = solution(m, n, cityMap);

        bw.write(result + "\n");

        bw.flush();
        br.close();
        bw.close();
    }

    public static int solution(int m, int n, int[][] cityMap) {
        // 0: 왼쪽에서 온 경우의 수 // 1: 위에서 온 경우의 수
        int[][][] dp = new int[m][n][2];

        dp[0][0][0] = 1;  // 왼쪽에서 온 경우
        dp[0][0][1] = 1;  // 위에서 온 경우

        cityMap[0][0] = 2;

        // i는 y축, j는 x축
        for (int i = 0; i < m; i++) {  // m은 y축
            for (int j = 0; j < n; j++) {  // n은 x축
                if (cityMap[i][j] == 1) continue;  // 벽인 경우 건너뛰기

                for (int k = 0; k < 2; k++) {
                    int nx = j + dx[k];  // 위쪽 또는 왼쪽 방향으로 이동
                    int ny = i + dy[k];  // 위쪽 또는 왼쪽 방향으로 이동

                    // 좌표 유효성 체크와 벽을 넘어가거나 벽이 있는 곳을 거르기
                    if (!validation(cityMap, ny, nx) || cityMap[ny][nx] == 1) continue;

                    if (cityMap[ny][nx] == 2) { // 2
                        dp[i][j][k] += dp[ny][nx][k];
                    } else {
                        dp[i][j][k] += dp[ny][nx][0] + dp[ny][nx][1];
                    }
                    dp[i][j][k] %= MOD;
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j][0] + "" + dp[i][j][1] + " ");
            }
            System.out.println();
        }

        return (dp[m - 1][n - 1][0] + dp[m - 1][n - 1][1]) % MOD;
    }

    // 좌표 유효성 검사
    public static boolean validation(int[][] cityMap, int ny, int nx) {
        if (ny < 0 || ny >= cityMap.length || nx < 0 || nx >= cityMap[0].length) return false;
        return true;
    }
}
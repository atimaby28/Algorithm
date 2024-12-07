package silver.one;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_11660_구간합구하기5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] nums = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] arrSum = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                arrSum[i][j] = arrSum[i][j - 1] + arrSum[i - 1][j] - arrSum[i - 1][j - 1] + nums[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            sb.append(solution(arrSum, x1, y1, x2, y2)).append("\n");
        }


        bw.write(sb + "\n");

        bw.flush();

        br.close();
        bw.close();
    }

    private static int solution(int[][] arrSum, int x1, int y1, int x2, int y2) {
        int answer = 0;

        answer = arrSum[x2][y2] - arrSum[x1 - 1][y2] - arrSum[x2][y1 - 1] + arrSum[x1 - 1][y1 - 1];

        return answer;
    }
}

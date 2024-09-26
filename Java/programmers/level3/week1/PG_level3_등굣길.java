package level3.week1;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level3_등굣길 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] puddles = new int[m][n];

        for (int i = 0; i < puddles.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < puddles[i].length; j++) {
                puddles[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = solution(m, n, puddles);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(int m, int n, int[][] puddles) {
        int answer = 0;

        int mod = 1_000_000_007;

        int[][] board = new int[n + 1][m + 1];

        for (int i = 0; i < puddles.length; i++) {
            board[puddles[i][1]][puddles[i][0]] = -1;
        }

        board[1][1] = 1;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {

                if(board[i][j] == -1) continue;

                if(board[i][j - 1] > 0) board[i][j] += board[i][j - 1] % mod;
                if(board[i - 1][j] > 0) board[i][j] += board[i - 1][j] % mod;

            }
        }

        answer = board[n][m] % mod;

        return answer;
    }

}

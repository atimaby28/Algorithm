package level2.week3;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level2_가장큰정사각형찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[][] board = new int[p][q];

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < q; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = solution(board);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(int[][] board) {
        int[][] map = new int[board.length + 1][board[0].length + 1];

        int maxLen = 0;

        for (int i = 1; i <= board.length; i++) {
            for (int j = 1; j <= board[0].length; j++) {

                if (board[i - 1][j - 1] != 0) {
                    int min = Math.min(Math.min(map[i - 1][j], map[i][j - 1]), map[i - 1][j - 1]);
                    map[i][j] = min + 1;

                    maxLen = Math.max(maxLen, map[i][j]);
                }
            }
        }

        return maxLen * maxLen;
    }
}

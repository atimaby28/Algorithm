package level0.week4;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level0_이차원배열대각선순회하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] board = new int[m][n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int k = Integer.parseInt(br.readLine());

        int result = solution(board, k);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }
    public static int solution(int[][] board, int k) {
        int answer = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(i + j <= k) {
                    answer += board[i][j];
                }
            }
        }

        return answer;
    }

}

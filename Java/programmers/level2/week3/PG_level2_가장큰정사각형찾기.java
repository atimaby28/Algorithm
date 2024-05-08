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
        int answer = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 1) {
                    answer = Math.max(answer, findSquare(board, i, j));
                }
            }
        }

        return answer;
    }

    public static int findSquare(int[][] board, int y, int x) {
        int s = 1;
        boolean flag = true;

        while(flag) {
            if(y + s > board.length - 1 || x + s > board[0].length - 1) {
                break;
            }
            for (int i = y; i < y + s; i++) {
                for (int j = x; j < x + s; j++) {
                    if(board[i][j] == 0) {
                        return 0;
                    }
                }
            }
            s++;
        }

        return s * s;
    }
}

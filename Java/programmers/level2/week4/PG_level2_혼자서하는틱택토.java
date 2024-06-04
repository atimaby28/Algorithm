package level2.week4;

import java.io.*;

public class PG_level2_혼자서하는틱택토 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] board = new String[3];

        for (int i = 0; i < board.length; i++) {
            board[i] = br.readLine();
        }

        int result = solution(board);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(String[] board) {
        int answer = -1;

        char[][] tiktactoe = new char[3][3];

        for (int i = 0; i < 3; i++) {
            String s = board[i];
            for (int j = 0; j < 3; j++) {
                tiktactoe[i][j] = s.charAt(j);
            }
        }

        answer = isPossible(tiktactoe);

        return answer;
    }

    private static int isPossible(char[][] tiktactoe) {

        int xCnt = 0, oCnt = 0;
        for (int i = 0; i < tiktactoe.length; i++) {
            for (int j = 0; j < tiktactoe[0].length; j++) {
                if(tiktactoe[i][j] == 'O') {
                    oCnt++;
                } else if(tiktactoe[i][j] == 'X') {
                    xCnt++;
                }
            }
        }

        if(oCnt != xCnt) {
            if(oCnt == 1) {
                return 1;
            }
            return 0;
        } else {
            if(oCnt == 3 && xCnt == 3) {
                return 0;
            }
            return 1;
        }
    }

}

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
        for (char[] chars : tiktactoe) {
            for (int j = 0; j < tiktactoe[0].length; j++) {
                if (chars[j] == 'O') {
                    oCnt++;
                } else if (chars[j] == 'X') {
                    xCnt++;
                }
            }
        }

        /*
        5가지 조건
        1. 'X'가 'O' 보다 많을 경우
        2. 'O'가 'X' 보다 2개 이상 많을 경우
        3. 'O'가 승리 했을 때, 'X'와 'O'의 갯수가 같을 때
        4. 'X'가 승리 했을 때, 'O'의 갯수가 'X'의 갯수보다 많을 때
         */

        if(xCnt > oCnt) return 0;
        else if(oCnt - xCnt >= 2) return 0;

        if(checkWinner(tiktactoe, 'O')) {
            if(xCnt == oCnt) return 0;
        }

        if(checkWinner(tiktactoe, 'X')) {
            if(oCnt > xCnt) return 0;
        }

        return 1;
    }

    private static boolean checkWinner(char[][] tiktactoe, char ox) {

        for (int i = 0; i < 3; i++) {
            // row check
            if(tiktactoe[i][0] == ox && tiktactoe[i][1] == ox && tiktactoe[i][2] == ox) return true;
            // column check
            else if(tiktactoe[0][i] == ox && tiktactoe[1][i] == ox && tiktactoe[2][i] == ox) return true;
        }

        // diagonal check
        if(tiktactoe[0][0] == ox && tiktactoe[1][1] == ox && tiktactoe[2][2] == ox) return true;
        else if(tiktactoe[0][2] == ox && tiktactoe[1][1] == ox && tiktactoe[2][0] == ox) return true;

        return false;
    }

}

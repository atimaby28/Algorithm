package level2.week2;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class PG_level2_프렌즈4블록 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int k = Integer.parseInt(br.readLine());
        String[] board = new String[k];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < board.length; i++) {
            board[i] = st.nextToken();
        }

        int result = solution(m, n, board);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }


    public static int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] map = new char[m][n];

        for (int i = 0; i < m; ++i) {
            map[i] = board[i].toCharArray();
        }

        while (true) {
            int cnt = checkBlock(m, n, map);
            if (cnt == 0) break;
            answer += cnt;

            dropBlock(m, n, map);
        }

        return answer;
    }

    // 2x2 형태의 블록을 찾는 함수
    private static int checkBlock(int m, int n, char[][] map) {
        int cnt = 0;
        boolean[][] isChecked = new boolean[m][n];

        for (int i = 0; i <= m - 2; i++) {
            for (int j = 0; j <= n - 2; j++) {
                if (map[i][j] == '.') continue;
                checkFour(map, isChecked, i, j);
            }
        }

        // isChecked 배열에 true로 체크된 갯수와 그 위치를 '.' 으로 바꿈
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isChecked[i][j]) {
                    cnt++;
                    map[i][j] = '.';
                }
            }
        }

        return cnt;
    }

    // 시작 위치의 우하향 방향으로 2x2가 모두 같은지 확인하는 함수
    private static void checkFour(char[][] map, boolean[][] isChecked, int i, int j) {
        char block = map[i][j];

        for (int r = i; r < i + 2; r++) {
            for (int c = j; c < j + 2; c++) {
                if (map[r][c] != block) return;
            }
        }

        for (int r = i; r < i + 2; r++) {
            for (int c = j; c < j + 2; c++) {
                isChecked[r][c] = true;
            }
        }
    }

    // 블록을 떨어뜨리는 로직.
    // 블록은 위에서 아래로 떨어지므로 행이아닌 열로 접근을 하며 시작 '.'의 위치에 끝나는 '.' 위치의 다음 위치를 대입한다.
    private static void dropBlock(int m, int n, char[][] map) {
        for (int c = 0; c < n; c++) {
            for (int r = m - 1; r >= 0; r--) {
                if (map[r][c] == '.') {
                    for (int nr = r - 1; nr >= 0; nr--) {
                        if (map[nr][c] != '.') {
                            map[r][c] = map[nr][c];
                            map[nr][c] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }

}

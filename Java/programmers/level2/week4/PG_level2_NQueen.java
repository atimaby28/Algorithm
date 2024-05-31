package level2.week4;

import java.io.*;

public class PG_level2_NQueen {

    public static int[] board;
    public static boolean[][] visited;

    public static int[] dx = {0, 0, -1, 1, -1, 1, 1, -1};
    public static int[] dy = {-1, 1, 0, 0, -1, -1, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int result = solution(n);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(int n) {
        int answer = 0;

        board = new int[n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            visited[0][i] = true;
            dfs(n, 0, i);
        }

        return answer;
    }

    private static void dfs(int n, int y, int x) {
        if(x == n) {
            return;
        }

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;

            visited[ny][nx] = true;
            if(isValid(ny)) dfs(n, ny + 1, nx);
            visited[ny][nx] = false;

        }
    }

    private static boolean isValid(int ny) {
        // 마지막으로 놓여진 것과 이전의 것들을 비교
        for (int j = 0; j < ny; j++) {
            if (board[ny] == board[j]) return false;
            if (Math.abs(ny - j) == Math.abs(board[ny] - board[j])) return false;
        }
        return true;
    }

}

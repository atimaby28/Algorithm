package level2.week3;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level2_리코쳇로봇 {

    public static final int INF = 987654321;
    public static int[] dx = {-1,0,1,0};
    public static int[] dy = {0,1,0,-1};

    public static int X, Y;
    public static char[][] map = new char[100][100];
    public static int [][] cache = new int[100][100];
    public static int startX, startY, endX, endY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        String[] board = new String[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            board[i] = st.nextToken();
        }

        int result = solution(board);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static int solution(String[] board) {
        int answer = 0;
        //초기화
        init(board);

        //해법
        cache[startX][startY] = 0;
        dfs(startX, startY, 0);
        answer = (cache[endX][endY] == INF) ? -1 : cache[endX][endY];

        //반환
        return answer;
    }

    public static void dfs(int x, int y, int cnt) {
        if (isEnd(x, y)) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x, ny = y;
            while (canGo(nx, ny, i)) {
                nx += dx[i];
                ny += dy[i];
            }
            if (cnt + 1 < cache[nx][ny]) {
                cache[nx][ny] = cnt + 1;
                dfs(nx, ny, cnt + 1);
            }
        }
    }

    public static boolean isEnd(int x, int y) {
        if (x == endX && y == endY) {
            return true;d
        }
        return false;
    }

    public static boolean canGo(int x, int y, int dir) {
        int nx = x + dx[dir], ny = y + dy[dir];
        if (nx < 0 || ny < 0 || nx >= X || ny >= Y || map[nx][ny] == 'D') {
            return false;
        }
        return true;
    }

    public static void init(String[] board) {
        X = board.length;
        Y = board[0].length();
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                char c = board[i].charAt(j);
                if (c == 'R') {
                    startX = i;
                    startY = j;
                    map[i][j] = '.';
                } else if (c == 'G') {
                    endX = i;
                    endY = j;
                    map[i][j] = '.';
                } else {
                    map[i][j] = c;
                }
                cache[i][j] = INF;
            }
        }
    }

}

/*
5
...D..R
.D.G...
....D.D
D....D.
..D....
 */
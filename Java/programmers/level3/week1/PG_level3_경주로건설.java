package level3.week1;

import java.io.*;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class PG_level3_경주로건설 {

    static int row, column;

    static final int DIRECTION = 4;
    static final int STRAIGHT_COST = 100;
    static final int CORNER_COST = 500;

    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[][] board = new int[p][q];

        for (int i = 0; i < board.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = solution(board);

        bw.write(result + "\n");

        bw.flush();
        br.close();
        bw.close();
    }

    public static int solution(int[][] board) {
        int answer = 0;

        row = board.length;
        column = board[0].length;

        int[][][] visited = new int[row][column][DIRECTION];

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                for(int d = 0; d < DIRECTION; d++) {
                    visited[i][j][d] = Integer.MAX_VALUE;
                }
            }
        }

        answer = bfs(board, visited);

        return answer;
    }

    private static int bfs(int[][] board, int[][][] visited) {
        Queue<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[]{0, 0, -1});

        for (int i = 0; i < DIRECTION; i++) {
            visited[0][0][i] = 0;
        }

        int minCost = Integer.MAX_VALUE;
        while(!queue.isEmpty()) {
            int[] pos = queue.poll();

            int cy = pos[0];
            int cx = pos[1];
            int cd = pos[2];

            // 도착지에 도달했을 때 최소 비용 갱신
            if(cx == column - 1 && cy == row -1) {
                minCost = Math.min(minCost, visited[cy][cx][cd]);
                continue;
            }

            for(int i = 0; i < DIRECTION; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx < 0 || nx >= column || ny < 0 || ny >= row || board[ny][nx] == 1) {
                    continue;
                }

                int newCost = visited[cy][cx][cd == -1 ? 0 : cd];

                // 첫 출발 시에는 직선 이동 비용을 추가 또는 이전 방향과 같은 방향으로 직선 이동 (비용 100)
                if(cd == i || cd == -1) {
                    newCost += STRAIGHT_COST;
                } else {
                    // 코너 이동 (방향이 바뀌면 비용 600)
                    newCost += (CORNER_COST + STRAIGHT_COST);
                }

                // 더 낮은 비용으로 해당 위치에 도달한 경우만 갱신
                if(newCost < visited[ny][nx][i]) {
                    visited[ny][nx][i] = newCost;
                    queue.offer(new int[]{ny, nx, i});
                }

            }
        }

        return minCost;
    }
}

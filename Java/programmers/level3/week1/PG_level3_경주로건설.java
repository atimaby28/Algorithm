package level3.week1;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class PG_level3_경주로건설 {

    static int[] dx = {0, 0, -1, 1}; // 상하좌우
    static int[] dy = {-1, 1, 0, 0}; // 상하좌우
    static final int STRAIGHT_COST = 100;
    static final int CORNER_COST = 500;

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

        int[][][] visited = new int[board.length][board[0].length][4]; // 각 위치의 최소 비용을 저장

        // visited 배열을 무한으로 초기화
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                for (int d = 0; d < 4; d++) {
                    visited[i][j][d] = Integer.MAX_VALUE;
                }
            }
        }

        answer = bfs(board, visited);

        return answer;
    }

    private static int bfs(int[][] board, int[][][] visited) {
        Queue<int[]> queue = new LinkedList<>();

        // 시작점 큐에 넣기 (비용 0, 방향 초기화)
        queue.offer(new int[]{0, 0, -1});  // {y, x, prevDir}

        for (int i = 0; i < 4; i++) {
            visited[0][0][i] = 0;
        }

        int minCost = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            int cy = cur[0];  // 현재 y 좌표
            int cx = cur[1];  // 현재 x 좌표
            int prevDir = cur[2]; // 이전 방향

            // 도착지에 도달했을 때 최소 비용 갱신
            if (cx == board[0].length - 1 && cy == board.length - 1) {
                minCost = Math.min(minCost, visited[cy][cx][prevDir]);
                continue;
            }

            // 4방향으로 이동
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                // 범위를 벗어나거나 벽인 경우는 무시
                if (nx < 0 || ny < 0 || nx >= board[0].length || ny >= board.length || board[ny][nx] == 1) continue;

                int newCost = visited[cy][cx][prevDir == -1 ? 0 : prevDir]; // 첫 출발 시 prevDir은 -1, 그 이후에는 이전 방향으로 이동

                // 첫 출발 시에는 직선 이동 비용을 추가 또는 이전 방향과 같은 방향으로 직선 이동 (비용 100)
                if (prevDir == -1 || prevDir == i) {
                    newCost += STRAIGHT_COST;
                } else {
                // 코너 이동 (방향이 바뀌면 비용 600)
                    newCost += (CORNER_COST + STRAIGHT_COST);
                }

                // 더 낮은 비용으로 해당 위치에 도달한 경우만 갱신
                if (newCost < visited[ny][nx][i]) {
                    visited[ny][nx][i] = newCost;
                    queue.offer(new int[]{ny, nx, i});  // {y, x, direction}
                }
            }
        }

        return minCost;
    }
}

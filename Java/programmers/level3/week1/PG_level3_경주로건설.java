package level3.week1;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class PG_level3_경주로건설 {

    static boolean[][] visited;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0 ,0};
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

        visited = new boolean[board.length][board[0].length];

        answer = bfs(board);

        return answer;
    }

    private static int bfs(int[][] board) {
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{0, 0});

        int cost = 0;
        while (!queue.isEmpty()) {

        }

        return cost;
    }

}

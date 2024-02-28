package level1.week4;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level1_이웃한칸 {

    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0 , 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        String[][] board = new String[p][q];

        for (int i = 0; i < board.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = st.nextToken();
            }
        }

        st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int result = solution(board, h, w);

        bw.write(result + "\n");

        bw.flush();
        bw.close();

    }

    public static int solution(String[][] board, int h, int w) {
        int answer = 0;

        for (int k = 0; k < 4; k++) {
            int nx = w + dx[k];
            int ny = h + dy[k];

            if((nx >= 0 && nx < board.length) && (ny >= 0 && ny < board.length)) {
                if(board[h][w].equals(board[ny][nx])) {
                    answer++;
                }
            }
        }

        return answer;
    }

}

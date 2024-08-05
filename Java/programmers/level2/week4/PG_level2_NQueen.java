package level2.week4;

import java.io.*;

public class PG_level2_NQueen {

    public static int answer;
    public static int[] board;

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

        dfs(0, n);
        answer = backTrack(0, board, n);

        return answer;
    }

    public static void dfs(int depth, int n) {

        if(depth == n) {
            answer++;
            return;
        }

        for(int i = 0; i < n; i++) {
            board[depth] = i;

            if(isValid(depth)) {
                dfs(depth + 1, n);
            }
        }
    }

    // dfs 탐색을 void가 아닌 int로 반환하는 경우
    public static int backTrack(int depth, int[] board, int n) {
        int sum = 0;
        if (depth == n) {
            return 1;
        } else {
            for (int i = 0; i < n; i++) {
                board[depth] = i;
                if (isValid(depth, board)) {
                    sum += backTrack(depth + 1, board, n);
                }
            }
        }
        return sum;
    }

    public static boolean isValid(int depth) {
        for(int i = 0; i < depth; i++) {
            if(board[depth] == board[i]) return false;
            if(Math.abs(i - depth) == Math.abs(board[i] - board[depth])) return false;
        }

        return true;
    }

    public static boolean isValid(int depth, int[] board) {
        for(int i = 0; i < depth; i++) {
            if(board[depth] == board[i] || (Math.abs(i - depth) == Math.abs(board[i] - board[depth]))) return false;
        }

        return true;
    }

}

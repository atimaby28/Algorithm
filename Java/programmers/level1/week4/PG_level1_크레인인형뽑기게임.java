package level1.week4;

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class PG_level1_크레인인형뽑기게임 {

    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;

        int x = Integer.parseInt(br.readLine());

        int[][] board = new int[x][x];

        for (int i = 0; i < board.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int y = Integer.parseInt(br.readLine());

        int[] moves = new int[y];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < moves.length; i++) {
            moves[i] = Integer.parseInt(st.nextToken());
        }

        int result = solution(board, moves);

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;

        ArrayList<Integer> arrayList = new ArrayList();
        Stack<Integer> stack = new Stack<>();


        for (int k = 0; k < moves.length; k++) {
            boolean flag = false;
            for (int i = moves[k] - 1; i < board.length; i++) {
                if(flag) {
                    break;
                }
                for (int j = 0; j < board.length; j++) {

                    if(board[board.length - 1][i] == 0) {
                        flag = true;
                        break;
                    }
                    if (board[j][i] != 0 ) {
                        if(stack.isEmpty()) {
                            stack.push(board[j][i]);
                        } else if(board[j][i] == 0) {
                            break;
                        }else {
                            if(stack.peek() == board[j][i]) {
                                answer++;
                                stack.pop();
                            } else {
                                stack.push(board[j][i]);
                            }
                        }
                        board[j][i] = 0;
                        flag = true;
                        break;
                    }
                }
            }
        }

        return answer * 2;
    }

}

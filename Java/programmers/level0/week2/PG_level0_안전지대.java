package level0.week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.StringTokenizer;

public class PG_level0_안전지대 {
	
	public static int[] dx = {0, 0, -1, 1, -1, 1, 1, -1};
	public static int[] dy = {1, -1, 0, 0, -1, -1, 1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] board = new int[n][n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int result = solution(board);

		bw.write(result + "\n");

		bw.flush();
		bw.close();

	}
	
    public static int solution(int[][] board) {
        int answer = 0;
        
        for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if(board[i][j] == 1) {
					
					int nx = 0;
					int ny = 0;
					
					for (int g = 0; g < 8; g++) {
						nx = j + dx[g];
						ny = i + dy[g];
					}
				}
			}
		}
        
        return answer;
    }
    
}

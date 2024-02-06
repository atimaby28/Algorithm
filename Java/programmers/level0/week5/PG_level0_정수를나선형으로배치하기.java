package level0.week5;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level0_정수를나선형으로배치하기 {

	private static final int[] DY = {-1,0,1,0};
	private static final int[] DX = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		int[][] result = solution(n);

		bw.write(result + "\n");

		bw.flush();
		bw.close();
	}

	public static int[][] solution(int n) {
		int[][] answer = makeMap(n);
		return answer;
	}

	private static int[][] makeMap(int n){
		int[][] answer = new int[n][n];

		int y = 0;
		int x = 0;

		int num = 1;
		int dir = 1;

		while(y >= 0 && y < n && x >= 0 && x < n){
			if(answer[y][x] != 0){
				break;
			}

			answer[y][x] = num++;

			y += DY[dir];
			x += DX[dir];

			if(x < 0 || x >= n || y < 0 || y >= n || answer[y][x] != 0){
				y -= DY[dir];
				x -= DX[dir];
				dir = (dir+1) % 4;
				y += DY[dir];
				x += DX[dir];
			}
		}
		return answer;
	}

}

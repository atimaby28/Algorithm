package level0.week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class PG_level0_평행 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = null;
		
		int[][] dots = new int[4][2];

		for (int i = 0; i < dots.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < dots[i].length; j++) {
				dots[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int result = solution(dots);

		bw.write(result + "\n");

		bw.flush();
		bw.close();
		
	}
	
	public static int solution(int[][] dots) {
		int answer = 1;

		double s1 = Math.abs((double)(dots[1][1] - dots[0][1]) / (dots[1][0] - dots[0][0]));
		double s2 = Math.abs((double)(dots[2][1] - dots[0][1]) / (dots[2][0] - dots[0][0]));
		double s3 = Math.abs((double)(dots[3][1] - dots[0][1]) / (dots[3][0] - dots[0][0]));
		double s4 = Math.abs((double)(dots[2][1] - dots[1][1]) / (dots[2][0] - dots[1][0]));
		double s5 = Math.abs((double)(dots[3][1] - dots[1][1]) / (dots[3][0] - dots[1][0]));
		double s6 = Math.abs((double)(dots[3][1] - dots[2][1]) / (dots[3][0] - dots[2][0]));

		if(s1 != s6 && s3 != s4 && s2 != s5) {
			answer = 0;
		}

		return answer;
		
	}

}

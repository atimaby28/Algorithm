package level0.week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class PG_level0_직사각형넓이구하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = null;

		int[][] dots = new int[4][2];

		for (int i = 0; i < dots.length; i++) {
			st = new StringTokenizer(br.readLine());
			dots[i][0] = Integer.parseInt(st.nextToken());
			dots[i][1] = Integer.parseInt(st.nextToken());
		}

		int result = solution(dots);

		bw.write(result + "\n");

		bw.flush();
		bw.close();

	}
	
    public static int solution(int[][] dots) {
        int answer = 0;
        
        double l1 = Math.sqrt(((dots[1][0] - dots[0][0]) * (dots[1][0] - dots[0][0])) 
        		+ ((dots[1][1] - dots[0][1]) * (dots[1][1] - dots[0][1])));
        
        double l2 = Math.sqrt(((dots[1][0] - dots[3][0]) * (dots[1][0] - dots[3][0])) 
        		+ ((dots[1][1] - dots[3][1]) * (dots[1][1] - dots[3][1])));
        

        if(l1 > l2) {
        	answer = Math.abs(dots[2][0] - dots[1][0]) * (dots[1][0] - dots[3][0]);
        } else {
        	answer = Math.abs(dots[1][0] - dots[0][0]) * (dots[2][1] - dots[1][1]);
        }
        
        return answer;
    }

}

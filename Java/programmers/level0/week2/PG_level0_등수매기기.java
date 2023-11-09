package level0.week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PG_level0_등수매기기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = null;
		
		int k = Integer.parseInt(br.readLine());
		int[][] score = new int[k][2];
		
		for (int i = 0; i < score.length; i++) {
			st = new StringTokenizer(br.readLine());
			
			score[i][0] = Integer.parseInt(st.nextToken());
			score[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int[] result = solution(score);

		bw.write(result + "\n");

		bw.flush();
		bw.close();
		
	}
	
    public static int[] solution(int[][] score) {
        int[] answer = {};
        
		int[] avg = new int[score.length];
		
		for (int i = 0; i < score.length; i++) {
			avg[i] = (score[i][0] + score[i][1]) / 2;
		}
		
		for (int i = 0; i < avg.length; i++) {
			System.out.print(avg[i] + " ");
		}
		
		Arrays.sort(avg);
		
		for (int i = 0; i < avg.length; i++) {
			System.out.print(avg[i] + " ");
		}
        
        return answer;
    }

}

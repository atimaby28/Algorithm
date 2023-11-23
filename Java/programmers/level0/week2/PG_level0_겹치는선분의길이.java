package level0.week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class PG_level0_겹치는선분의길이 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = null;

		int[][] lines = new int[3][2];

		for (int i = 0; i < lines.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < lines[i].length; j++) {
				lines[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int result = solution(lines);

		bw.write(result + "\n");

		bw.flush();
		bw.close();

	}
	
    public static int solution(int[][] lines) {
        int answer = 0;
        
        int[] check = new int[201];
        
        for (int i = 0; i < lines.length; i++) {
			for (int j = lines[i][0] + 100 + 1; j <= lines[i][1] + 100; j++) {
				check[j]++;
			}
		}
        
        for (int i = 0; i < check.length; i++) {
			if(check[i] >= 2) {
				answer++;
			}
		}
        
        
        return answer;
    }

}

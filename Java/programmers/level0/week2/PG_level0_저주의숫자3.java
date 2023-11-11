package level0.week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class PG_level0_저주의숫자3 {

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

        for (int i = 1; i <= n; i++) {
        	answer++;
        	
        	while (answer % 3 == 0 || Integer.toString(answer).contains("3")) {
        		answer++;
        	}
        	
//            if (answer % 3 == 0 || String.valueOf(answer).contains("3")) {
//                i--;
//            }
        	
		}
        
        return answer;
    }

}

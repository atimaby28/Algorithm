package level0.week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PG_level0_짝수는싫어요 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());

		int[] result = solution(n);
		
		bw.write(result + "\n");
		
		bw.close();
		bw.flush();
		
	}
	
    public static int[] solution(int n) {
        int[] answer = {};
        
        if(n % 2 != 0) {
        	answer = new int[n / 2 + 1];
        } else {
        	answer = new int[n / 2];
        }
        
        int k = 0;
        for (int i = 1; i <= n; i+= 2) {
			answer[k++] = i;
		}
        
        return answer;
    }

}
package level0.week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PG_level0_피자나눠먹기1 {

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
        int answer = 1;
        
        if(n % 7 == 0) {
        	answer -= 1;
        }
        answer += (n / 7);
    	
//    	int answer = (n + 6) / 7;
        
        return answer;
    }

}
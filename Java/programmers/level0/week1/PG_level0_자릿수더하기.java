package level0.week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PG_level0_자릿수더하기 {

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
        
        while(n > 0) {
        	answer += n % 10;
        	n /= 10;
        }
        
        return answer;
    }

}
package level0.week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PG_level0_편지 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String message = br.readLine();
		
		int result = solution(message);

		bw.write(result + "\n");

		bw.flush();
		bw.close();

	}
	
    public static int solution(String message) {
        int answer = 0;
        
        answer = message.length() * 2;
        
        return answer;
    }

}
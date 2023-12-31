package level0.week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PG_level0_암호해독 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String cipher = br.readLine();
		
		int code = Integer.parseInt(br.readLine());
		
		String result = solution(cipher, code);
		
		bw.write(result + "\n");
		
		bw.flush();
		bw.close();
	}
	
    public static String solution(String cipher, int code) {
        String answer = "";
        
        for (int i = code - 1; i < cipher.length(); i+= code) {
			answer += cipher.charAt(i);
		}
        
        return answer;
    }

}
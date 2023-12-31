package level0.week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PG_level0_가위바위보 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String rsp = br.readLine();
		
		String result = solution(rsp);
		
		bw.write(result + "\n");
		
		bw.flush();
		bw.close();
	}
	
    public static String solution(String rsp) {
        String answer = "";
        
        for (int i = 0; i < rsp.length(); i++) {
			if(rsp.charAt(i) == '0') {
				answer += '5';
			} else if(rsp.charAt(i) == '2') {
				answer += '0';
			} else {
				answer += '2';
			}
		}
        
        return answer;
    }

}
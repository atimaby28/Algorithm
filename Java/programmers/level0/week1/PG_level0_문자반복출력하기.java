package level0.week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PG_level0_문자반복출력하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String my_string = br.readLine();
		int n = Integer.parseInt(br.readLine());
		
		String result = solution(my_string, n);

		bw.write(result + "\n");

		bw.flush();
		bw.close();

	}
	
    public static String solution(String my_string, int n) {
        String answer = "";
        
        for (int i = 0; i < my_string.length(); i++) {
			for (int j = 0; j < n; j++) {
				answer += my_string.charAt(i);
			}
		}
        
        return answer;
    }

}
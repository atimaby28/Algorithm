package level0.week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PG_level0_문자열뒤집기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String my_string = br.readLine();

		String result = solution(my_string);

		bw.write(result + "\n");

		bw.flush();
		bw.close();

	}
	
    public static String solution(String my_string) {
        String answer = "";
        
        for (int i = my_string.length(); i >= 0 ; i--) {
			answer += my_string.charAt(i);
		}
        
        return answer;
    }

}
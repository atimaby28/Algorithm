package level0.week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PG_level0_숨어있는숫자의덧셈1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String my_string = br.readLine();
		
		int result = solution(my_string);

		bw.write(result + "\n");

		bw.flush();
		bw.close();

	}
	
    public static int solution(String my_string) {
        int answer = 0;
        
        String new_string = my_string.replaceAll("[A-Za-z]", "");
        
       for (int i = 0; i < new_string.length(); i++) {
		answer += new_string.charAt(i) - '0';
	}
        
        return answer;
    }

}
package level0.week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PG_level0_모음제거 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String message = br.readLine();
		
		String result = solution(message);

		bw.write(result + "\n");

		bw.flush();
		bw.close();

	}
	
    public static String solution(String my_string) {
        String answer = "";
        
        my_string = my_string.replaceAll("[aeiou]", "");
        
        answer = my_string;
        
        return answer;
    }

}
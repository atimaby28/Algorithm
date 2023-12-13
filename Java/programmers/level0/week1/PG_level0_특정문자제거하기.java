package level0.week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class PG_level0_특정문자제거하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String my_string = st.nextToken();
		String letter = st.nextToken();
		
		String result = solution(my_string, letter);

		bw.write(result + "\n");

		bw.flush();
		bw.close();

	}
	
    public static String solution(String my_string, String letter) {
        String answer = "";
        
        answer = my_string.replaceAll(letter, "");
        
        return answer;
    }

}

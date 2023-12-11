package level0.week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class PG_level0_문자열안에문자열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String str1 = st.nextToken();
		String str2 = st.nextToken();
		
		int result = solution(str1, str2);

		bw.write(result + "\n");

		bw.flush();
		bw.close();

	}
	
    public static int solution(String str1, String str2) {
        int answer = 0;
        
        if(str1.contains(str2)) {
        	answer = 1;
        } else {
        	answer = 2;
        }
        
        return answer;
    }

}
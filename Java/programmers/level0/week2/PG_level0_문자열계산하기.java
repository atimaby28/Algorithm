package level0.week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class PG_level0_문자열계산하기 {

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
		
		StringTokenizer st = new StringTokenizer(my_string, " ");
		
		answer += Integer.parseInt(st.nextToken());
		
		while(st.hasMoreTokens()) {
			if(st.nextToken().equals("+")) {
				answer += Integer.parseInt(st.nextToken());
			} else {
				answer -= Integer.parseInt(st.nextToken());
			}
		}
		
		return answer;
	}

}

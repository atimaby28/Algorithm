package level0.week4;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class PG_level0_공백으로구분하기2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String my_string = br.readLine();

		String[] result = solution(my_string);

		bw.write(result + "\n");

		bw.flush();
		bw.close();
	}

	public static String[] solution(String my_string) {
		String[] answer = {};

		String[] temp = my_string.split(" ");

		for (String str : temp) {
			if(!str.equals("")) {
				answer = Arrays.copyOf(answer, answer.length + 1);
				answer[answer.length - 1] = str;
			}
		}

		return answer;
	}

//	public String[] solution(String my_string) {
//		return my_string.trim().split("[ ]+");
//	}

//	public String[] solution(String my_string) {
//		StringTokenizer st = new StringTokenizer(my_string);
//		int N = st.countTokens();
//		String[] result = new String[N];
//		for (int n = 0;n < N;n++)
//			result[n] = st.nextToken();
//		return result;
//	}

}

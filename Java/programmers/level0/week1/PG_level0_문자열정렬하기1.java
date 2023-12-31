package level0.week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class PG_level0_문자열정렬하기1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String my_string = br.readLine();

		int[] result = solution(my_string);

		bw.write(result + "\n");

		bw.flush();
		bw.close();
	}

	public static int[] solution(String my_string) {
		int[] answer = {};

		my_string = my_string.replaceAll("[A-z]", "");

		answer = new int[my_string.length()];

		for (int i = 0; i < answer.length; i++) {
			answer[i] = (int)(my_string.charAt(i) - '0');
		}
		
		Arrays.sort(answer);

		return answer;
	}

}
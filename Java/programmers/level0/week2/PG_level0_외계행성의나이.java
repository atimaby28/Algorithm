package level0.week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PG_level0_외계행성의나이 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int age = Integer.parseInt(br.readLine());

		String result = solution(age);

		bw.write(result + " ");

		bw.flush();
		bw.close();

	}

	public static String solution(int age) {
		String answer = "";

		char[] chars = new char[26];

		for (int i = 0; i < chars.length; i++) {
			chars[i] = (char) ('a' + i);
		}

		String reverse = "";
		while (age > 0) {
			reverse += chars[age % 10];
			age /= 10;
		}

		for (int i = reverse.length() - 1; i >= 0; i--) {
			answer = answer + reverse.charAt(i);
		}

		return answer;
	}

}
package level0.week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PG_level0_잘라서배열로저장하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String my_str = br.readLine();

		int n = Integer.parseInt(br.readLine());

		String[] result = solution(my_str, n);

		bw.write(result + "\n");

		bw.flush();
		bw.close();

	}

	public static String[] solution(String my_str, int n) {
		String[] answer = {};

		int len = 0;
		if (my_str.length() % 2 == 0) {
			len = my_str.length() / n + 1;
		} else {
			len = my_str.length() / n;
		}

		answer = new String[len];

		int k = 0;
		for (int i = 0; i < len; i++) {
			answer[i] = ""; 
			for (int j = 0; j < n; j++) {
				if(k > my_str.length() - 1) {
					break;
				}
				answer[i] += my_str.charAt(k++);
			}
		}	

		return answer;
	}

}

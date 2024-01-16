package level0.week3;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level0_배열에서문자열대소문자변환하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = null;

		int k = Integer.parseInt(br.readLine());

		String[] strArr = new String[k];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < strArr.length; i++) {
			strArr[i] = st.nextToken();
		}

		String[] result = solution(strArr);

		bw.write(result + "\n");

		bw.flush();
		bw.close();
	}

	public static String[] solution(String[] strArr) {
		String[] answer = new String[strArr.length];

		for (int i = 0; i < answer.length; i++) {
			if(i % 2 != 0) {
				answer[i] = strArr[i].toUpperCase();
			} else {
				answer[i] = strArr[i].toLowerCase();
			}

		}

		return answer;
	}

}

package level0.week5;

import java.io.*;
import java.util.StringTokenizer;

public class PG_level0_qrcode {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int q = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		String code = br.readLine();

		String result = solution(q, r, code);

		bw.write(result + "\n");

		bw.flush();
		bw.close();
	}

	public static String solution(int q, int r, String code) {
		String answer = "";

		for (int i = 0; i < code.length(); i++) {
			if(i % q == r) {
				answer += code.charAt(i);
			}
		}

		return answer;
	}

}

package level0.week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PG_level0_각도기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int angle = Integer.parseInt(br.readLine());

		int result = solution(angle);

		bw.write(result + "\n");

		bw.flush();
		bw.close();
	}

	public static int solution(int angle) {
		int answer = 0;

		if(angle > 0 && angle < 90) {
			answer = 1;
		} else if(angle == 90) {
			answer = 2;
		} else if(angle == 180) {
			answer = 4;
		} else {
			answer = 3;
		}
		
		return answer;
	}

}